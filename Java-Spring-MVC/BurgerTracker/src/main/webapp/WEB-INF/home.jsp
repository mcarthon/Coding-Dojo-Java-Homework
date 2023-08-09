<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
</head>
<body>

	<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Burger Name</th>
      <th scope="col">Restaurant Name</th>
      <th scope="col">Rating</th>
      <th scope="col">Notes</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${allBurgers}" var="burger">
    <tr>			
			<td>${burger.burgerName}</td>
			<td>${burger.restaurantName}</td>
			<td>${burger.rating}</td>
			<td>${burger.notes}</td>
    </tr>
	</c:forEach>
  </tbody>
</table>

	<form:form action="/newBurger" method="post" modelAttribute="newBurger">
    <div class="form-group">
        <label>Burger Name: </label>
        <form:input path="burgerName" class="form-control" />
        <form:errors path="burgerName" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Restaurant Name: </label>
        <form:input path="restaurantName" class="form-control" />
        <form:errors path="restaurantName" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Rating: </label>
        <form:input type="number" path="rating" class="form-control" />
        <form:errors path="rating" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Notes: </label>
        <form:input type="text" path="notes" class="form-control" />
        <form:errors path="notes" class="text-danger" />
    </div>
    <input type="submit" value="Add New Burger" class="btn btn-primary" />
</form:form>

</body>
</html>