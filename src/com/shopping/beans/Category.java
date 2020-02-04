package com.shopping.beans;

public class Category {
	
	private int categoryID;
	private String productCategory;
	
	public Category() {}
	
	public Category(int categoryID, String productCategory) {
		super();
		this.categoryID = categoryID;
		this.productCategory = productCategory;
	}
	
		
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

}
