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
<c:if test="${param.regStatus=='Fail' }">
<h3>Registration Unsuccessful</h3>
</c:if>

CREATE YOUR ACCOUNT
<form action="register" method="post">
Email ID : <input type="email" name="email" id="email" place-holder="Enter email-id"/>
<br>
Password : <input type="password" name="password" id="password" place-holder="Enter password" />
<br>
<button type="submit">Create Account</button>
</form>
<br>
<h5>ALREADY REGISTERED? LOGIN HERE</h5>
<form action="login" method="post">
Email ID : <input type="email" name="email" id="email" place-holder="Enter email-id" />
<br>
Password: <input type="password" name="password" id="password" place-holder="Enter password" />
<br>
<button type="submit">Login</button>	
<a href="forgotpassword.html">Forgot Password</a>
</form>

</body>
</html>