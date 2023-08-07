<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>

	<a href="/"> Home </a>

	<p> You have visited this site <c:out value="${ count }"/> times </p>
	
	<a href="/reset-counter"> Reset Count </a>

</body>
</html>