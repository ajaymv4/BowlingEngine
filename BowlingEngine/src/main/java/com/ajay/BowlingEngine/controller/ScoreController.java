package com.ajay.BowlingEngine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.BowlingEngine.dto.Frame;
import com.ajay.BowlingEngine.service.ScoreCalculator;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/bowlingengine")
public class ScoreController {
	
	
	@Autowired
	ScoreCalculator scoreCalculator;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/calculatescore",method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public @ResponseBody String login(@RequestBody List<Frame> frames,HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("Request recieved is ==>"+frames.toString());
		String responseJson = "";
		try{
			 responseJson = objectMapper.writeValueAsString(scoreCalculator.calculateScore(frames));
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		
		return responseJson;
	}


}
