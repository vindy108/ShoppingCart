<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
Home
<c:url var="home" value="/home"></c:url>
<a href="${home}">Shopping Cart</a>

Categories:::
<c:forEach var="categories" items="${categories}">
	<li>
	
	<select name="category">
	<option><a href="#"><c:out value="${categories.key}"></c:out></a>
	</select>
				
	
	
	Sub-Categories
<c:forEach var="subCategories" items="${categories.value}">
	<c:url var="url" value="/category">
		<c:param name="subcateg" value="${subCategories}"></c:param>
		<c:param name="categ" value="${categories.key}"></c:param>
	</c:url>
	
	<a href="${url}"><c:out value="${subCategories}"></c:out></a>
</c:forEach>
	</li>
</c:forEach>




Cart

Login


Products

<c:forEach var="products" items="${productList}">
	<c:url var="url" value="/product">
	
		<c:param name="productID" value="${products.productID}" />
	</c:url>
	<li>
	<a href="${url}">${products.productName}</a>
	</li>
</c:forEach>


</body>
</html>