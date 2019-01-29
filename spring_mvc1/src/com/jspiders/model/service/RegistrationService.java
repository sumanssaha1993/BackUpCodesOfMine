package com.jspiders.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.dto.RegistrationDTO;
import com.jspiders.model.dao.RegistrationDAO;

@Service
public class RegistrationService {
@Autowired  
private RegistrationDAO dao;

public boolean isSave(RegistrationDTO dto) {
	System.out.println("inside isSave method of service");
	return dao.save(dto);
	
}
}
