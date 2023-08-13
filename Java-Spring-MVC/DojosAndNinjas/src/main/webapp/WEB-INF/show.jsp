<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${dojo.name}" /></title>
</head>
<body>

	<a href="/"> New Dojo </a>
	
	<a href="/ninjas"> New Ninja </a>

	<h1> <c:out value="${dojo.name}" /> </h1>

	<c:forEach items="${allNinjas}" var="ninja">
	
		<p> <c:out value="${ninja.firstName} ${ninja.lastName} ${ninja.age}" /> </p>
	
	</c:forEach>

</body>
</html>