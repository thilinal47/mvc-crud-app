package com.mvcapp.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mvcapp.dao.contract.UserDAO;
import com.mvcapp.dao.impl.UserDAOImpl;
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
	public String registerForm(@ModelAttribute("registerForm") User user, Model model) {
		model.addAttribute("loginForm", new User());
		UserDAO userDAO = new UserDAOImpl();
		userDAO.saveUser(user);
		return "login";

	}
}
