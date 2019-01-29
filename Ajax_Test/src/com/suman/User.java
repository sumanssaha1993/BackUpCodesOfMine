package com.suman;

import com.annotations.table;

@table(name="user")
public class User {
	private String id;
	private String name;
	private Double salary;
	public String getID() {
		return id;
	}
	public void setID(String iD) {
		id = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "User [ID=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
		
}
