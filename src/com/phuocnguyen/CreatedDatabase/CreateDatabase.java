package com.phuocnguyen.CreatedDatabase;

import java.sql.Connection;
import java.sql.Statement;

import com.phuocnguyen.Connection.JDBCConnection;

public class CreateDatabase {

	public static String createDatabase(String nameDatabase) {
		try {
			Connection connection = JDBCConnection.getJDBCConnection();
			Statement statement = connection.createStatement();
			String sql = "CREATE DATABASE " + nameDatabase;
			int result = statement.executeUpdate(sql);
			System.out.println(result);
			System.out.println("Database created successfully...");
			return nameDatabase;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static void main(String[] args) {
		createDatabase("DBTable");
	}

}
