<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${user.userName}"/></title>
</head>
<body>

	<p> Hi <c:out value="${user.userName}" /></p>

	<a href="/logout"> Logout </a>

</body>
</html>