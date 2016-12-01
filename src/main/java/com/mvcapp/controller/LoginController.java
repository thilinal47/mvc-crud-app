package com.mvcapp.controller;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcapp.model.User;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(ModelMap model) {

		User userLogin = new User();
		model.put("loginForm", userLogin);
		return "login";
	}

	@RequestMapping(value = "/loginData}", method = RequestMethod.GET)
	public String loginToCRUD(@ModelAttribute("loginForm") User user, Map<String, Object> model) {

		return "home";
	}

}
