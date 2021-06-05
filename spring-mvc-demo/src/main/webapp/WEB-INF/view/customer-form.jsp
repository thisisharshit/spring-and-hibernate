<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Form</title>
<style>
	.error{
		color:red
	}
</style>
</head>
<body>
<i>Fill out the form</i><br></br>
	<form:form action="processForm" modelAttribute="customer">
		First Name: <form:input path="firstName"/> <%-- call customer.getFirstName() method --%>
		<br></br>
		Last Name(*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/> <%--display error message --%>
		<br></br>
		Free Passes: <form:input path="freePasses"/> 
		<form:errors path="freePasses" cssClass="error"/>
		<br></br>
		Postal Code: <form:input path="postalCode"/> 
		<form:errors path="postalCode" cssClass="error"/>
		<br></br>
		Course Code: <form:input path="courseCode"/> 
		<form:errors path="courseCode" cssClass="error"/>
		<br></br>
		<input type="submit" value="Enter">
	</form:form>
</body>
</html>