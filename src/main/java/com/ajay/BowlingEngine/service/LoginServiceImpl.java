package com.ajay.BowlingEngine.service;

import org.springframework.stereotype.Component;

import com.ajay.BowlingEngine.dto.User;

@Component
public class LoginServiceImpl implements LoginService{

	@Override
	public boolean verifyCredentials(User user){
		if(user.getUserName().equals("ajaymv.4@gmail.com") 
				&& user.getPassword().equals("password")){
			return true;
		}else{
			return false;
		}
	}
	
}
