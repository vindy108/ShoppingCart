package com.shopping.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.beans.Category;
import com.shopping.beans.Product;
import com.shopping.dao.DBConnection;

public class ProductService {
	
	
	private List<Product> products = null;
	private List<Category> category= null;
	private List<String> subcategory = null;
	private static Connection con;
	private String categoryName;
	
	public List<Product> getAllProducts() throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		products = new ArrayList<Product>();
		try {
			con = DBConnection.getConnection();
			String query = "select * from products";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt("productid"),
										rs.getString("productname"),
										rs.getDouble("productprice"),
										rs.getString("description"),
										rs.getString("category"),
										rs.getString("subcategory"),
										rs.getString("productmanufacturer")
										);
				products.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return products;

}
	
	
	
	public Product getProductDetails(int productID) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product p = new Product();
		
		try {
			con = DBConnection.getConnection();
			String query = "select productid, productname,productprice,description,category,subcategory,productmanufacturer from products where productid=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, productID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				p.setProductID(rs.getInt("productid"));
				p.setProductName(rs.getString("productname"));
				p.setProductPrice(rs.getDouble("productprice"));
				p.setDescription(rs.getString("description"));
				p.setCategoryName(rs.getString("category"));
				p.setSubCategory(rs.getString("subcategory"));
				p.setProductManufacturer(rs.getString("productmanufacturer"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}if(ps!=null) {
					ps.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}
	
	
	public List<Product> getProductByCategory(String category){
		PreparedStatement ps = null;
		ResultSet rs = null;
		products = new ArrayList<Product>();
		
		try {
			con = DBConnection.getConnection();
			String query = "select productid,productname,productprice,description,category,productmanufacturer from products where category=? ";
			ps = con.prepareStatement(query);
			ps.setString(1, category);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),
						rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6)
						
						);
				products.add(p);
				
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}if(ps!=null) {
					ps.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return products;
		
	}
	
	
	public List<Product> getProductBySubCategory(String subCategory){
		PreparedStatement ps = null;
		ResultSet rs = null;
		products = new ArrayList<Product>();
		
		try {
			con = DBConnection.getConnection();
			String query = "select productid,productname,productprice,description,category,productmanufacturer from products where subcategory=? ";
			ps = con.prepareStatement(query);
			ps.setString(1, subCategory);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),
						rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6)
						
						);
				products.add(p);
				
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}if(ps!=null) {
					ps.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return products;
		
	}
	
	
	public String getCategoryBySubCategory(String subCategory) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			String query = "select category from products where subcategory=?";
			ps = con.prepareStatement(query);
			ps.setString(1, subCategory);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				categoryName = rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}if(ps!=null) {
					ps.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return categoryName;
	}
	
	
	
	public List<Category> getAllCategories(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		category = new ArrayList<Category>();
		
		try {
			con = DBConnection.getConnection();
			String query  = "select productid,category from categories";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Category c = new Category(rs.getInt(1),rs.getString(2));
				category.add(c);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}if(ps!=null) {
					ps.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return category;
	}
	
	public List<String> getSubCategory(Category c){
		PreparedStatement ps = null;
		ResultSet rs = null;
		subcategory = new ArrayList<String>();
		
		try {
			con = DBConnection.getConnection();
			String query = "select productsubcategory from subcategory where category=?";
			ps = con.prepareStatement(query);
			ps.setString(1, c.getProductCategory());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				subcategory.add(rs.getString(1));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}if(ps!=null) {
					ps.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return subcategory;
	}
	
}