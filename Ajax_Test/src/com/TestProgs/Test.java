package com.TestProgs;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.suman.DBConnectionUtil;

public class Test {

	public static void main(String[] args) {
		/*Employee emp = new Employee();
		emp.setEmp_id("MM0419");
		emp.setEmp_name("Suman");
		emp.setEmp_designation("Dev");
		Calendar cl =  Calendar.getInstance();
	    cl.set(2012, 8, 12);
	    Timestamp timestamp = new Timestamp(cl.getTimeInMillis());
	    
		emp.setJoin_date(timestamp);
		emp.setSalary(15000.0);
		emp.setIs_active(true);*/
		
		SalesOrder so = new SalesOrder();
		so.setAddress_id(102);
		so.setCustomer_id(108);
		so.setDelv_status("Pending");
		
		Calendar cl =  Calendar.getInstance();
	    cl.set(2012, 8, 12);
	    Timestamp timestamp = new Timestamp(cl.getTimeInMillis());
		so.setOrder_date(timestamp);
		so.setP_so_id(201);
		so.setR_gross_amt(400.0);
		so.setR_net_amt(450.0);
		so.setR_tax_amt(50.0);
		so.setStatus("placed");
	    	  
		DBConnectionUtil dbs = new DBConnectionUtil();
//		dbs.save(emp);
		dbs.save(so);
	}
}
