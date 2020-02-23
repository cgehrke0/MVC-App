package com.collabera.todoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController2 {
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	// string
	// view html repsonse and send it back
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required = false) String logout, 
			ModelMap model) {
		String errorMessage = null;
		
		if (error!=null) {
			errorMessage="Wrong Credentials";
		}
		if (logout!=null) {
			errorMessage="You have successfully logged out!!";
		}
		
		model.put("errorMessage", errorMessage);
	//public String login(@RequestParam (defaultValue="guest") String name, ModelMap model) {
	//	System.out.println(name);
	//	model.put("names", name);
		return "loginSecure";
	}
	
	@RequestMapping(value= "/forbidden", method=RequestMethod.GET) 
	public String login() {
		return "forbidden";
	}

}
