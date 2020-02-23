package com.collabera.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.collabera.todoapp.services.LoginService;

//@Controller
@SessionAttributes("name")
public class LoginController {
	
	// /login
	@Autowired
	LoginService logSvc;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	// string
	// view html repsonse and send it back
	public String login() {
	//public String login(@RequestParam (defaultValue="guest") String name, ModelMap model) {
	//	System.out.println(name);
	//	model.put("names", name);
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String validateLogin(@RequestParam (defaultValue="guest") String name, @RequestParam String password, ModelMap model) {
		
		if(!logSvc.validateUser(name,  password)) {
			return "login";
		}
		else {
		//System.out.println(password);
		model.put("name", name);
		return "welcome";
		}
	}

}
