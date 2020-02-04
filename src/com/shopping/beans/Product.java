package com.shopping.beans;

public class Product {
	
	private int productID;
	private String productName;
	private double productPrice;
	private String description;
	private String categoryName;
	private String subCategory;
	private String productManufacturer;
	
	public Product() {};
		
	
	public Product(int productID, String productName, double productPrice, String description, String categoryName,
			String subCategory, String productManufacturer) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.description = description;
		this.categoryName = categoryName;
		this.subCategory = subCategory;
		this.productManufacturer = productManufacturer;
	}
		
	

	public Product(int productID, String productName, double productPrice, String description, String categoryName,
			String productManufacturer) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.description = description;
		this.categoryName = categoryName;
		this.productManufacturer = productManufacturer;
	}


	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}

}
