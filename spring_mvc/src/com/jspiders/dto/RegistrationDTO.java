package com.jspiders.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegistrationDTO {
	private String name;
	@Id
	private String email;
	private String phone;
	private String addr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "RegistrationDTO [name=" + name + ", email=" + email
				+ ", phone=" + phone + ", addr=" + addr + "]";
	}

}
