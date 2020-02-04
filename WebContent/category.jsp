<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url var="url" value="/category">
	<c:param name="categ" value="${catName}"></c:param>
</c:url>
	<a href="${url}">${catName}</a>
	<p>${subCat}</p>
</body>
</html>