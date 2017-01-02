package com.mvcapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvcapp.dao.contract.UserDAO;
import com.mvcapp.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void saveUser(User user) {

		String sql = "INSERT INTO user(UserName, Password) VALUES(?, ?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());

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
	public User getUser(User user) {

		String sql = "SELECT * FROM user WHERE UserName = ? ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		User newUser = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserName());

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				newUser = new User();
				newUser.setUserName(resultSet.getString(1));
				newUser.setPassword(resultSet.getString(2));
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

		return newUser;
	}

}
