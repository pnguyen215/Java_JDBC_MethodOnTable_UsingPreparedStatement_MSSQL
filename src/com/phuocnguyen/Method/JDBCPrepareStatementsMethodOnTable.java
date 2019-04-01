package com.phuocnguyen.Method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.phuocnguyen.Connection.JDBCConnection_Already_DB;

public class JDBCPrepareStatementsMethodOnTable {
	public static void insertRecords(String username, String password) {

		try {
			Connection connection = JDBCConnection_Already_DB.getJDBCConnection();
			String sql = "insert into login (username,password) VALUES (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
			connection.close();
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		// insertRecords("admin", "123456");
		// insertRecords("user", "123456");
		// insertRecords("phuocnguyen", "123456");
		System.out.println("Completely!");
	}
}
