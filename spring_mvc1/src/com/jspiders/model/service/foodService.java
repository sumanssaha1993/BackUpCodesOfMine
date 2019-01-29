package com.jspiders.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.dto.foodDTO;
import com.jspiders.model.dao.foodDAO;

@Service
public class foodService {
	@Autowired
	private foodDAO dao;

	public foodDTO requestFood(String foodid) {
		return dao.get(foodid);
	}
}
