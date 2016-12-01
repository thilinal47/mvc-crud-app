package com.mvcapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcapp.model.User;

@Controller
public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Map<String, Object> model) {
		User userForm = new User();
		model.put("registerForm", userForm);		
		return "register";
	}

	@RequestMapping(value = "/sendData", method = RequestMethod.POST)
	public String registerForm(@ModelAttribute("registerForm") User user, Map<String, Object> model) {	
		System.out.println(user.getUserName());
		return "login";
	}
}
