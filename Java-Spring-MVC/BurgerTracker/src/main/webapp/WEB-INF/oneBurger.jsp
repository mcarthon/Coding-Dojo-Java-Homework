<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${burger.burgerName}"/></title>
</head>
<body>

	<a href="/">See All Burgers</a>
	
	<a href="/edit/${id}">Edit Burger</a>

	<h1> <c:out value="${burger.burgerName}" /> </h1>

	<p> Restaurant Name: <c:out value="${burger.restaurantName}" /> </p>
	
	<p> Rating: <c:out value="${burger.rating}" /> </p>
	
	<p> Notes: <c:out value="${burger.notes}" /> </p>

</body>
</html>