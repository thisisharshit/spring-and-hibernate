<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- add support for JSTL core tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.harshit.springdemo.sorting.SortUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers List</title>
<!-- reference our style sheet -->
 <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id = "content">
		
			<!-- put new button: add Customer -->
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" 
					class="add-button"/>
			
			<!-- Adding a search box -->
				
			<form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
            
			<!-- add our html table here -->
			<table>
				<!-- construct a sort link for first name -->
				<c:url var="sortLinkFirstName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
				</c:url>
				<c:url var="sortLinkLastName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
				</c:url>
				<c:url var="sortLinkEmail" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
				</c:url>
				<tr>

				
					<th><a href="${sortLinkFirstName}">First Name</a></th>
					<th><a href="${sortLinkLastName}">Last Name</a></th>
					<th><a href="${sortLinkEmail}">Email</a></th>
					<th>Action</th>
					<!-- loop over and print customers -->
					<c:forEach var="tcustomer" items="${customers}">
					
						<!--  construct an "Update" link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tcustomer.id}"></c:param>
						</c:url>
						
						<!--  construct an "Delete" link with customer id -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tcustomer.id}"></c:param>
						</c:url>
						<tr>
							<td>${tcustomer.firstName}</td>
							<td>${tcustomer.lastName}</td>
							<td>${tcustomer.email}</td>
							<td>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure want to delete this customer?'))) return false">Delete</a>
							</td>
							
						</tr>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>