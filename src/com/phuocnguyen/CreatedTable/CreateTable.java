package com.phuocnguyen.CreatedTable;

import java.sql.Connection;
import java.sql.Statement;

import com.phuocnguyen.Connection.JDBCConnection_Already_DB;

public class CreateTable {

	public static void createTable(String nameTable) {
		Connection connection = JDBCConnection_Already_DB.getJDBCConnection();
		try {

			Statement statmemt = connection.createStatement();
			String sql = "create table " + nameTable;
			int result = statmemt.executeUpdate(sql);
			System.out.println(result);
			connection.close();
			statmemt.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		createTable(" login(username varchar(45) primary key, password varchar(50))");
		System.out.println("Created table in given database...");
	}

}
