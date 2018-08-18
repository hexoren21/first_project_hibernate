package com.przemyslaw.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/baza_hibernate?useSSL=false&serverTimezone=UTC";
		String user = "Test_hibernate";
		String pass = "test";
		try{
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful");
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
