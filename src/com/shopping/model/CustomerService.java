package com.shopping.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shopping.dao.DBConnection;

public class CustomerService {
	
	private Connection con;
	
	public boolean registerUser(String email,String password) {
		PreparedStatement ps = null;
		
		try {
		con = DBConnection.getConnection();
		String query = "insert into user_details (email,password) values(?,?)";
		ps = con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		
		int result = ps.executeUpdate();
		if(result > 0) {
			return true;
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(ps!=null) {
				ps.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
 return false;
}
	
	
	
	public boolean verifyUser(String email , String password) {
		PreparedStatement ps = null;
		
		try {
			con = DBConnection.getConnection();
			String query = "Select email from user_details where email=? and password=?";
			ps = con.prepareStatement(query);
			ps.setString(1,email );
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("email") != null) {
					return true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) {
					ps.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}