package com.jspiders.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.dto.AccountEntity;
import com.jspiders.dto.EmployeeEntity;
import com.jspiders.model.dao.RegistrationDAO;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationDAO dao;

	public boolean isSave() {
		System.out.println("inside isSave method of service............");
		return dao.save();
			
	}

}
