<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit <c:out value="${burger.burgerName}"/></title>
</head>
<body>

<a href="/">See All Burgers</a>

	<form:form action="/edit/${burger.id}" method="patch" modelAttribute="burger">
	
    <div class="form-group">
        <label>Burger Name: </label>
        <form:input path="burgerName" value="${burger.burgerName}" class="form-control" />
        <form:errors path="burgerName" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Restaurant Name: </label>
        <form:input path="restaurantName" value="${burger.restaurantName}" class="form-control" />
        <form:errors path="restaurantName" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Rating: </label>
        <form:input type="number" value="${burger.rating}" path="rating" class="form-control" />
        <form:errors path="rating" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Notes: </label>
        <form:input type="text" value="${burger.notes}" path="notes" class="form-control" />
        <form:errors path="notes" class="text-danger" />
    </div>
    <input type="submit" value="Edit Burger" class="btn btn-primary" />
</form:form>

</body>
</html>