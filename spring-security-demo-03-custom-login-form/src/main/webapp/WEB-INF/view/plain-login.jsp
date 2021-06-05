<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Custom Login Form</title>
<style>
	.failed{
		color:red;
	}
</style>
</head>
<body>
	<h3>MY CUSTOM LOGIN PAGE</h3>
	
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
		<!-- check for login error -->
		<c:if test="${param.error!=null}">
			<i class="failed">Sorry! You have entered invalid username or password</i>
		</c:if>
		<p>
		User name: <input type="text" name="username"/> <!-- these names are default form field names for spring security to read  -->
		</p>
		<p>
		Password: <input type="password" name="password"/>
		</p>
		<input type="submit" value="Login"/>
	</form:form>
</body>
</html>