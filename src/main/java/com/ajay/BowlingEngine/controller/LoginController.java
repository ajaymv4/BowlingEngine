package com.ajay.BowlingEngine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.BowlingEngine.dto.User;
import com.ajay.BowlingEngine.service.LoginService;

@RestController
@RequestMapping("/bowlingengine")
public class LoginController {
	
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/sayHello",method=RequestMethod.GET)
	public String sayHello(){
		return "Hi from Bowling engine";
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/login",method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public @ResponseBody String login(@RequestBody User user,HttpServletRequest request, HttpServletResponse response){
		
		String responseJson;
		if(loginService.verifyCredentials(user)){
			responseJson = "{\"status\":\"success\"}";
		}else{
			responseJson = "{\"status\":\"failure\"}";
		}
		
		return responseJson;
	}

	

}
