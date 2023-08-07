<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>
<body>

	<c:forEach var="fruit" items="${ fruits }">

		<div class="row">

		<p> <c:out value="${ fruit.name }"> </c:out> </p>
		
		<p> <c:out value="${ fruit.price }"> </c:out> </p>
		
		</div>
	
	</c:forEach>

</body>
</html>