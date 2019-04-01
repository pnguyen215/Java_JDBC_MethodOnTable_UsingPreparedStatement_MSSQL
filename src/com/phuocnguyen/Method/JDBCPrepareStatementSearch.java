package com.phuocnguyen.Method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.phuocnguyen.Connection.JDBCConnection_Already_DB;

public class JDBCPrepareStatementSearch {

	public static String searchUser(String username) {
		Connection connection = JDBCConnection_Already_DB.getJDBCConnection();
		String sql = "select * from login";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String username_login = resultSet.getString(1);
				String password_login = resultSet.getString(2);
				/*
				 * compare each pairs
				 */
				if (username.equals(username_login)) {

					return username_login + " " + password_login;
				}
			}
			connection.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static void main(String[] args) {
		System.out.println(searchUser("admin"));
	}

}
