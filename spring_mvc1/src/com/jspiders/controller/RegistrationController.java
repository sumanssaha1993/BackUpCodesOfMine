package com.jspiders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jspiders.dto.RegistrationDTO;
import com.jspiders.model.service.RegistrationService;

@Controller
@RequestMapping("/")
public class RegistrationController {
@Autowired
private RegistrationService service;
@RequestMapping(value = "register.htm", method = RequestMethod.POST)
public String register(@ModelAttribute RegistrationDTO dto){
	String page=null;
	System.out.println("inside register method of controller");
	boolean isSave= service.isSave(dto);
	if(isSave){
		page="welcome.html";
	}
	else{
		page ="index.html";
	}
	return page;
}

	
}
