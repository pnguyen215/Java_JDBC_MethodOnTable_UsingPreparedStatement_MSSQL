package com.phuocnguyen.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection_Already_DB {

	public static Connection getJDBCConnection() {
		/*
		 * information for login into MSSQL
		 */
		final String username = "sa";
		final String password = "1109chenzhenmaivien";
		final String url = "jdbc:sqlserver://localhost:1433;databaseName=DBTable;username=" + username + ";password="
				+ password;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			return DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static void main(String[] args) {
		try {
			Connection connection = getJDBCConnection();
			if (connection != null) {
				System.out.println("Connection successful!");
			} else {
				System.out.println("Disconnect!");
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
