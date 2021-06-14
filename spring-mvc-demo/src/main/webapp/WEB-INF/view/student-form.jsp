<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Student Form</title>
	<style>
		.error{
			color:red;
		}
	</style>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstName"/> <%-- this will call the student.setFirstName() when clicking on submit --%>
	<form:errors path="firstName" cssClass="error"/>
	<br></br>
	Last Name: <form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error"/>
	<br></br>
	Country: 
	<form:select path="country">
		<%--
		<form:option value="Brazil" label="Brazil"/>
		<form:option value="France" label="France"/>
		<form:option value="Germany" label="Germany"/>
		<form:option value="India" label="India"/>
		--%>
		<%--<form:options items="${student.countryOptions}"/> this will call the student.getCountryOptions() method --%>
		<form:options items="${theCountryOptions}" />
	</form:select>
	<br></br>
	Favourite Language:
	Java <form:radiobutton path="favouriteLanguage" value="Java"/>
	C++ <form:radiobutton path="favouriteLanguage" value="C++"/>
	PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>
	Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/>
	<br></br>
	Operating Systems:
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
	MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
	
	<br></br>
	
	<input type="submit" value="Submit">
	</form:form>
	
</body>
</html>