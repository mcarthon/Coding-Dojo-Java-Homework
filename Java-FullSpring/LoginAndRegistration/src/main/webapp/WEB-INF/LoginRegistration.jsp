<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration Page</title>
</head>
<body>

	<h1>Register</h1>
	<form:form action = "/register" method = "post" modelAttribute = "userRegister">
	
		<label>Username: </label>
		<form:input path="userName" type="text" />
		<form:errors path="userName"/>
		
		<label>Email: </label>
		<form:input path="email" type="email" />
		<form:errors path="email"/>
		
		<label>Password: </label>
		<form:input path="password" type="password"/>
		<form:errors path="password"/>
		
		<label>Confirm Password: </label>
		<form:input path="confirm" type="password"/>
		<form:errors path="confirm"/>
		
		<input type="Submit" value="Register"/>
	
	</form:form>
	
	<h1>Login</h1>
	<form:form action = "/login" method = "post" modelAttribute = "userLogin">
	
		<label>Email: </label>
		<form:input path="email" type="email" />		
		
		<label>Password: </label>
		<form:input path="password" type="password"/>		
		
		<input type="Submit" value="Log In"/>
		
		<form:errors path="password"/>
		<form:errors path="email"/>
	
	</form:form>

</body>
</html>