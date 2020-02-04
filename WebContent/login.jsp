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
<c:choose>
	<c:when test="${regstatus == 'success'}">
		<c:choose>
			<c:when test="${param.regStatus == 'Success'}">
				<h3>Registration Successfull.Please login to complete the transaction</h3>
			</c:when>
			<c:otherwise><h3>Invalid email password,Please login with valid credentials</h3></c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
	<h3>Registration Unsuccessful</h3>
		<%-- <c:redirect url="checkout_unreg.jsp"></c:redirect> --%>
	</c:otherwise>
</c:choose>


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