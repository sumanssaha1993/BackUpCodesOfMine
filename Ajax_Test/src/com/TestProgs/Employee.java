package com.TestProgs;

import java.sql.Timestamp;

import com.annotations.table;

@table(name="dssor_emp_hdr")
public class Employee {

	private String emp_id;
	private String emp_name;
	private String emp_designation;
	private Timestamp join_date;
	private Double salary;
	private boolean is_active;
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_designation() {
		return emp_designation;
	}
	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}
	public Timestamp getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Timestamp join_date) {
		this.join_date = join_date;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_designation=" + emp_designation
				+ ", join_date=" + join_date + ", salary=" + salary + ", is_active=" + is_active + "]";
	}
	
		
}
