package com.shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	
	private static Connection con;

	private DBConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if(con != null) {
			return con;
		}else {
			return new DBConnection().con;
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","password");
			System.out.println("Connected to PostgreSQL database!");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from user_details");
			while(rs.next()) {
				System.out.println(rs.getString("email") + " " + rs.getString("password"));
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

		}
}




