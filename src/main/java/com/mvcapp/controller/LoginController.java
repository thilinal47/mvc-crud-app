package com.mvcapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcapp.dao.contract.EmployeeDAO;
import com.mvcapp.dao.contract.UserDAO;
import com.mvcapp.dao.impl.EmployeeDAOImpl;
import com.mvcapp.dao.impl.UserDAOImpl;
import com.mvcapp.model.Employee;
import com.mvcapp.model.User;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(ModelMap model) {
		User userLogin = new User();
		model.put("loginForm", userLogin);
		return "login";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(ModelMap model) {

		EmployeeDAO emmDAO = new EmployeeDAOImpl();
		List<Employee> employees = emmDAO.getEmployees();
		model.addAttribute("employees", employees);
		return "home";
	}

	@RequestMapping(value = "/loginData", method = RequestMethod.POST)
	public String loginToCRUD(@ModelAttribute("loginForm") User user, ModelMap model) {

		UserDAO userDAO = new UserDAOImpl();
		User getUser = userDAO.getUser(user);

		if (getUser != null) {	
			return "redirect:/list";
		} else {
			return "login";
		}
	}
}
