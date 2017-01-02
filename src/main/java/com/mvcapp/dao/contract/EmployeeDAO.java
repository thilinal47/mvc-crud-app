package com.mvcapp.dao.contract;

import java.util.List;

import com.mvcapp.model.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployees();
	public void deleteEmployee(int id);
	public Employee getEmployee(int id);
	public void updateEmployee(Employee employee);
	public void addEmployee(Employee employee);
}
