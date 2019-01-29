package com.suman;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ID = request.getParameter("ID").trim();
		String NAME = request.getParameter("NAME").trim();
		String SALARY = request.getParameter("SALARY").trim();
//		JSONObject obb = new JSONObject();
		JSONObject obj = new JSONObject();
		obj.put("ID", ID);
		obj.put("NAME", NAME);
		obj.put("SALARY", Double.parseDouble(SALARY));
//		obb.put("result", obj);
		
		User usr = new User();
		usr.setID(ID);
		usr.setName(NAME);
		usr.setSalary(Double.parseDouble(SALARY));
		DBConnectionUtil dbu = new DBConnectionUtil();
		dbu.save(usr);
		
		//PrintWriter out = response.getWriter();
        response.setContentType("application/json");
       // response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        String jsonData = obj.toString();
        response.getWriter().write(jsonData);
	}
}
