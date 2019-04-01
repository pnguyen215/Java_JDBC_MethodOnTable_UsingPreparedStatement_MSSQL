package com.phuocnguyen.Method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.phuocnguyen.Connection.JDBCConnection_Already_DB;
import com.phuocnguyen.entity.User;

public class JDBCListOnDatabase {

	public static List<User> listOnDB() {
		User user;
		List<User> listAllUser = new ArrayList<User>();
		/*
		 * check port connection
		 */
		Connection connection = JDBCConnection_Already_DB.getJDBCConnection();
		/*
		 * SQL query
		 */
		String sql = "select * from login";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String username_login = resultSet.getString(1);
				String password_login = resultSet.getString(2);
				/*
				 * mapping to User object ~ create new object
				 */
				user = new User(username_login, password_login);
				/*
				 * add to list
				 */
				listAllUser.add(user);
			}
			/*
			 * close all connection
			 */
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listAllUser;
	}

	public static void printfOut() {
		List<User> list = listOnDB();
		for (User user : list) {
			/*
			 * if (user.getUsername().equals("admin")) {
			 * System.out.println(user.toString()); }
			 */
			System.out.println(user.toString());
		}
	}

	public static void main(String[] args) {
		printfOut();
	}

}
