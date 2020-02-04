package com.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.beans.Product;
import com.shopping.model.CustomerService;
import com.shopping.model.ProductService;

public class DispatcherServlet extends HttpServlet{
	
	private HttpSession hs;
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html");
		String userPath = request.getServletPath();
		String contextPath = request.getContextPath();
		
		System.out.println("Userpath " + userPath + " ::  contextPath " + contextPath );
		
		String getURL="/" + userPath + ".jsp";
		if(userPath.equals("/home")) {
			ProductService ps = new ProductService();
			List<Product> productList = null;
			try {
				productList = ps.getAllProducts();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			getServletContext().setAttribute("productList", productList);
		}
		else if(userPath.equals("/product")) {
			int productID = Integer.parseInt(request.getParameter("productID"));
			ProductService ps = new ProductService();
			Product p = ps.getProductDetails(productID);
			hs = request.getSession();
			hs.setAttribute("product", p);
			hs.setAttribute("productId", productID);
			getServletContext().setAttribute("productCategory", p.getCategoryName());
			getServletContext().setAttribute("productSubCategory", p.getSubCategory());
			
		}
		
		else if(userPath.equals("/category")) {
			String category = request.getParameter("categ");
			String subCategory = request.getParameter("subcateg");
			ProductService ps = new ProductService();
			
			if(category!=null) {
				List<Product> categoryList = ps.getProductByCategory(category);
				request.setAttribute("productByCategory", categoryList);
				
			}
			
			if(subCategory!=null) {
				String categoryName = ps.getCategoryBySubCategory(subCategory);
				List<Product> categoryProducts = ps.getProductBySubCategory(subCategory);
				getServletContext().setAttribute("catName", categoryName);
				getServletContext().setAttribute("categoryProducts", categoryProducts);
			}
			
			getServletContext().setAttribute("subCat", subCategory);
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher(getURL);
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		
		response.setContentType("text/html");
		String userPath = request.getServletPath();
		//System.out.println("UserPath"+userPath);
		
		if(userPath.equals("/register")) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		CustomerService cs = new CustomerService();
		boolean status = cs.registerUser(email, password);
		
		if(status) {
			request.setAttribute("regstatus", "success");
			response.sendRedirect("login.jsp?regStatus=Success");
		}else {
			response.sendRedirect("checkout.jsp?regStatus=Fail");
		}
		}
		
		else if(userPath.equals("/login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			CustomerService cs = new CustomerService();
			boolean status = cs.verifyUser(email, password);
			if(status) {
				HttpSession hs = request.getSession();
				hs.setAttribute("email", email);
				response.sendRedirect("final_checkout.jsp");
			}else {
				response.sendRedirect("login.jsp?regStatus=Fail");
			}
			
		}
		//PrintWriter out  = response.getWriter();
		
		//out.println(email + ":" + password);
		
	}

}
