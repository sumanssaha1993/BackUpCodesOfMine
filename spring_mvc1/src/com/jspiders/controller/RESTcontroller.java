package com.jspiders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.dto.foodDTO;
import com.jspiders.model.service.foodService;

@RestController
@RequestMapping("/Foods")
public class RESTcontroller {
	/*@Autowired
	private foodService service;*/

	@RequestMapping(value = "/getFood/{foodid}", method = RequestMethod.GET)
	public String getFoodInfo(@PathVariable("foodid") String foodid) {
//		return service.requestFood(foodid);
		return "Suman";
	}
}
