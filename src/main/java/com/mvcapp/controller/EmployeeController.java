package com.mvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mvcapp.dao.contract.EmployeeDAO;
import com.mvcapp.dao.impl.EmployeeDAOImpl;
import com.mvcapp.model.Employee;

@Controller
public class EmployeeController {

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.addEmployee(employee);
		return "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String reditectAddEmploye(@ModelAttribute("employee") Employee employee) {
		return "add";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String reditectEditEmploye(@PathVariable int id, ModelMap model) {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee employee = employeeDAO.getEmployee(id);
		model.addAttribute("employee", employee);
		return "edit";
	}

	@RequestMapping(value = "edit/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.updateEmployee(employee);
		return "redirect:/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id) {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.deleteEmployee(id);
		return "redirect:/list";
	}

}
