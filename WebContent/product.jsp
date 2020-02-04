<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product page - Shopping Cart</title>
</head>
<body>
<li>
<c:url var="url" value="/category">
	<c:param name="categ" value="${productCategory}"></c:param>
</c:url>
	<a href="${url}">${productCategory}</a>
</li>
<li>
<c:url var="url" value="/category">
	<c:param name="subcateg" value="${productSubCategory}"></c:param>
</c:url>
	<a href="${url}">${ productSubCategory}</a>
</li>	
${product.productName }

Buy:

<p>${product.productID}</p>
<p>${product.productPrice}</p>
<p>${product.description}</p>
<p>${product.productManufacturer}</p>
</body>
</html>