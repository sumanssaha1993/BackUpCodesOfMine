package com.suman;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.annotations.table;




public class DBConnectionUtil {

	public void save(Object obj){
		try {
						
			String className = obj.getClass().toString().split(" ")[1];
			Class cls = Class.forName(className);
			Field[] temp = cls.getDeclaredFields();
			String ActualClassName = null;
			Annotation[] annot = cls.getAnnotations();
			for(Annotation annotation : annot){
			    if(annotation instanceof table){
			    	table tbl = (table) annotation;
			        //System.out.println("name: " + tbl.name());
			    	ActualClassName = tbl.name();
			    }
			}
			Map<String, Pair<Object, String>> holder = new LinkedHashMap<String, Pair<Object, String>>();
			
			for(int i =0; i<temp.length; i++){
				String[] tfld = temp[i].toString().split(" ")[2].split("\\.");
				String fldName = tfld[tfld.length-1];
				System.out.println(fldName);
					
				temp[i].setAccessible(true);
				Object fieldValue = temp[i].get(obj);
				if(temp[i].getType().toString().split(" ").length == 1){
					String fieldType = temp[i].getType().toString();
					holder.put(fldName, Pair.of(fieldValue, fieldType));
				}else{
					String fieldType = temp[i].getType().toString().split(" ")[1].split("\\.")[2];
					holder.put(fldName, Pair.of(fieldValue, fieldType));
				}
				
				
				System.out.println(fieldValue.toString());
				
			}
					
			System.out.println(obj.toString());
			
			if(ActualClassName == null){
				String[] clsnmParts = className.split("\\.");
				ActualClassName = clsnmParts[clsnmParts.length-1];
			}
			
			generateSQL(holder, "INSERT", ActualClassName);
			
		} catch (ClassNotFoundException  | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

	private void generateSQL(Map<String, Pair<Object, String>> holder, String SQLType, String TableName) {
		StringBuffer SQL = new StringBuffer(); 
		SQL.append(SQLType + " INTO " + TableName + "(");
		StringBuffer colnames = new StringBuffer();
		StringBuffer colvalues = new StringBuffer();
		colvalues.append(") VALUES (");
		boolean isFirstTime = true;
		
		for(String currentelement : holder.keySet()){
			if(!isFirstTime){
				colnames.append(", ");
			}
			else{
				isFirstTime = false;
			}
			colnames.append(currentelement);
		}
		
		isFirstTime = true;
		for(Pair<Object, String> pair : holder.values()){
			if(!isFirstTime){
				colvalues.append(", ");
			}
			else{
				isFirstTime = false;
			}
			if(pair.getRight().equalsIgnoreCase("String")){
				colvalues.append("'" + (String)pair.getLeft() + "'");
			}
			if(pair.getRight().equalsIgnoreCase("Double")){
				colvalues.append((Double)pair.getLeft());
			}
			
			if(pair.getRight().equalsIgnoreCase("Integer")){
				colvalues.append((Integer)pair.getLeft());
			}
			
			if(pair.getRight().equalsIgnoreCase("Float")){
				colvalues.append((Float)pair.getLeft());
			}
			
			if(pair.getRight().equalsIgnoreCase("boolean")){
				if(pair.getLeft() != null && pair.getLeft().toString().equalsIgnoreCase("true"))
				colvalues.append("'" + "1" + "'");
				else
				colvalues.append("'" + "0" + "'");
				
			}
			
			if(pair.getRight().equalsIgnoreCase("Timestamp")){
				SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
				colvalues.append("'" + ft.format(pair.getLeft()) + "'");
			}
		}
		colvalues.append(")");
		SQL.append(colnames.toString() + colvalues.toString());
		System.out.println(SQL.toString());
//		executeSQL(SQL.toString());
	}

	private void executeSQL(String SQL) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.2.66:3306/mig_test_12062018", "Klarion", "Cl@rion360");
			stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			System.out.println(SQL);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
