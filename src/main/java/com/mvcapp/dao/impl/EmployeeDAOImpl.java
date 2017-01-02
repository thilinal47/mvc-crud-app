package com.mvcapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvcapp.dao.contract.EmployeeDAO;
import com.mvcapp.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> getEmployees() {
		String sql = "SELECT * FROM employee";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setJoiningDate(resultSet.getDate(3).toLocalDate());
				employee.setSalary(resultSet.getBigDecimal(4));
				employee.setSsn(resultSet.getString(5));

				employees.add(employee);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return employees;

	}

	@Override
	public void deleteEmployee(int id) {

		String sql = "DELETE FROM employee WHERE id = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			int number = preparedStatement.executeUpdate();
			//System.out.println(number);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	@Override
	public Employee getEmployee(int id) {

		String sql = "SELECT * FROM employee WHERE id = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Employee employee = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setJoiningDate(resultSet.getDate(3).toLocalDate());
				employee.setSalary(resultSet.getBigDecimal(4));
				employee.setSsn(resultSet.getString(5));

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		String sql = "UPDATE employee SET name = ?, joining_date = ?, salary = ?, ssn = ? ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setDate(2, Date.valueOf(employee.getJoiningDate()));
			preparedStatement.setBigDecimal(3, employee.getSalary());
			preparedStatement.setString(4, employee.getSsn());

			int number = preparedStatement.executeUpdate();
			//System.out.println(number);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	@Override
	public void addEmployee(Employee employee) {
		String sql = "INSERT INTO employee VALUES(?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDate(3, Date.valueOf(employee.getJoiningDate()));
			preparedStatement.setBigDecimal(4, employee.getSalary());
			preparedStatement.setString(5, employee.getSsn());

			int number = preparedStatement.executeUpdate();
			//System.out.println(number);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end 
		
	}
}
