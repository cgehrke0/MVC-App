package com.collabera.todoapp.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public Boolean validateUser(String name, String password) {
		
		return name.equalsIgnoreCase("Carter") && password.equalsIgnoreCase("p");
	}

}
