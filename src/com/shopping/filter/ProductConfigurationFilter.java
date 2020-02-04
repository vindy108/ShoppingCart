package com.shopping.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.shopping.beans.Category;
import com.shopping.model.ProductService;

public class ProductConfigurationFilter implements Filter{
	
	private ServletContext context;
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context = fConfig.getServletContext();
		this.context.log("config products and categories");
		
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HashMap<String,List<String>> hm = new HashMap<String,List<String>>();
		ProductService ps = new ProductService();
		List<Category>categoryList = ps.getAllCategories();
		
		for(Category category:categoryList) {
			hm.put(category.getProductCategory(), ps.getSubCategory(category));
		}
		this.context.setAttribute("categories", hm);
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

	

}
