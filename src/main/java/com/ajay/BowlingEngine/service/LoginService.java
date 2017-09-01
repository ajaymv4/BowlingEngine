package com.ajay.BowlingEngine.service;

import org.springframework.stereotype.Component;

import com.ajay.BowlingEngine.dto.User;

@Component
public interface LoginService {
	
	public boolean verifyCredentials(User user);

}
