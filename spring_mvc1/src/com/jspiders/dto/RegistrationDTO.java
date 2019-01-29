package com.jspiders.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student_hdr")
public class RegistrationDTO {
@Id		
@GenericGenerator(name="incr",strategy="increment")
@GeneratedValue(generator="incr")
private int sid;
private String name;
private int age;
private String address;

public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "RegistrationDTO [sid=" + sid + ", name=" + name + ", age=" + age + ", address=" + address + "]";
}



}
