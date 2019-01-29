package com.maventic.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ScheduleTask extends TimerTask {
	
	final static Logger logger = Logger.getLogger(ScheduleTask.class);

	public static void checkExists(String directory) throws FileNotFoundException, SQLException {
		String file = null;
		boolean is_exists = false;
		File dir = new File(directory);
		File[] dir_contents = dir.listFiles();
		String temp = file + ".txt";
		boolean check = new File(directory, temp).exists();
//		System.out.println("Check : " + check);
		logger.info("Check : " + check);

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().contains(".json")){
				is_exists = true;
				file = dir_contents[i].getName();
			}
		}
		if (is_exists) {
//			System.out.println("FILE_EXISTS");
			logger.info("FILE_EXISTS");
			Path path;
			try {
				path = Files.move(Paths.get(directory + "\\" + file),Paths.get("C:\\Users\\mm0419\\Desktop\\my_temp1\\"+ "processed_" + file));
				Connection connection = null; 
				PreparedStatement statement = null;
				if (path != null) {
					System.out.println("File renamed and moved successfully");
					String filePath = "C:\\Users\\mm0419\\Desktop\\my_temp1\\"+ "processed_" + file;
					InputStream inputStream = new FileInputStream(new File(filePath));
					connection = DatabaseConnection.getConnection(); 
					if(!isAlreadyExists(inputStream)){
						int id = getNextId(connection);
						String sql = "INSERT INTO m_file (id,file) values (?,?)";
						statement = connection.prepareStatement(sql);
						statement.setInt(1, id);
						statement.setBlob(2, inputStream);
						statement.executeUpdate();
						logger.info("INSERT INTO m_file (id,file) values (" + id + ", " + inputStream + " )");
					}
					
				} else {
//					System.out.println("Failed to move the file");
					logger.error("Failed to move the file");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
//			System.out.println("FILE_DOES_NOT_EXIST");
			logger.error("FILE_DOES_NOT_EXIST");
		}
	}

	private static boolean isAlreadyExists(InputStream istream) {

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		List<InputStream > inputstream = new ArrayList<>();
		List<String> realmContainer = new ArrayList<>();
		try {
			con = DatabaseConnection.getConnection();
			String sql = "SELECT * FROM m_file";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			logger.info("SELECT * FROM m_file");
			while(rs.next()){
				inputstream.add(rs.getBinaryStream("file"));
			}
			if(!inputstream.isEmpty()){
				for(InputStream ips : inputstream){
					/*byte[] buffer = new byte[1024];
					FileOutputStream output = new FileOutputStream("C:\\Users\\mm0419\\Desktop\\my_temp\\temp.txt");
	                while (ips.read(buffer) > 0) {
	                    output.write(buffer);
	                }*/
					JSONParser jsonParser = new JSONParser();
					JSONObject jsonObject = (JSONObject)jsonParser.parse(new InputStreamReader(ips, "UTF-8"));
					String realm = (String) jsonObject.get("realm");
					String realm_public_key = (String) jsonObject.get("realm-public-key");
					System.out.println(realm);
					System.out.println(realm_public_key);
					realmContainer.add(realm);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;
		try {
			jsonObject = (JSONObject)jsonParser.parse(new InputStreamReader(istream, "UTF-8"));
			String realm = (String) jsonObject.get("realm");
			if(realmContainer.contains(realm)){
				return true;
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}

	private static int getNextId(Connection connection) {
		PreparedStatement statement = null;
		int id = 0;
		String sql = "SELECT MAX(id) id from m_file";
		
		try {
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			logger.info("SELECT MAX(id) id from m_file");
			while(rs.next()){
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id+1;
	}

	public void run() {
//		System.out.println("Executing FileChecker Thread.........");
		logger.info("Executing FileChecker Thread.........");
		try {
			checkExists("C:\\Users\\mm0419\\Desktop\\my_temp");
			
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
