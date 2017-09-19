package com.logistics.turvo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.classic.Logger;

@Controller
public class LoginController {

private static final Logger logger = (Logger) LoggerFactory.getLogger(LoginController.class);
	

	@RequestMapping(value="/")
	public String root(ModelMap model){
	logger.info("Inside root !");
	return "index";
	}

	@RequestMapping(value="/login")
	public String login(ModelMap model){
		logger.info("Inside Login !");
		return "login";
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(ModelMap model){
		logger.info("Inside index !");
		return "index";
	}

	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(ModelMap model){
		logger.info("Inside Logout !");
		return "customLogout";
	}
	
	 @RequestMapping(value="/403")
	 public String Error403(){
	        return "403";
	    }
	 
	 /*@RequestMapping(value="/error")
	 public String Error(){
	        return "403";
	    }*/
} 
