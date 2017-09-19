package com.logistics.turvo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

@Controller
public class UserController {

private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);
	

	@RequestMapping(value="/registerUser")
	public String registerUser(ModelMap model){
	logger.info("Inside User controller !");
	return "userRegistration";
	}
	
	@RequestMapping(value="/subscribe")
	public String subscribe(ModelMap model){
	logger.info("Inside User subscribe !");
	return "subscribe";
	}

		
} 
