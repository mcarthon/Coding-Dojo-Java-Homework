<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos and Ninjas</title>
</head>
<body>

	<a href="/ninjas"> Add New Ninja</a>

	<h2> New Dojo </h2>	
	<form:form action="/dojos" method="post" modelAttribute="dojo">
	
		<label> Dojo Name: </label>
		<form:input path="name" type="text"/>
		<form:errors path="name" />
		
		<input type="submit" value="Add New Dojo" />
	
	</form:form>	

</body>
</html>