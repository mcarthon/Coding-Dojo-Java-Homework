<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Baby Name</title>
</head>
<body>

	<h1>Add a name!</h1>

	<form:form action="/names/new" method="post" modelAttribute="newName">
    <div class="form-group">
        <label>New Name: </label>
        <form:input type="text" path="name" class="form-control" />
        <form:errors path="name" class="text-danger" />
    </div>
    
    <div class="form-group">
        <label>Typical Gender: </label>
        <form:select type="text" path="gender" class="form-control">
        
        	<form:option value="Male">Male</form:option>
        	
        	<form:option value="Female">Female</form:option>
        	
        	<form:option value="Neutral">Neutral</form:option>
        
        </form:select>
        <form:errors path="gender" class="text-danger" />
    </div>
    
    <div class="form-group">
        <label>Origin: </label>
        <form:input type="text" path="origin" class="form-control" />
        <form:errors path="origin" class="text-danger" />
    </div>  
    
    <div class="form-group">
        <label>Meaning: </label>
        <form:input type="text" path="meaning" class="form-control" />
        <form:errors path="meaning" class="text-danger" />
    </div> 
    
    
    <input type="submit" value="Add New Name" class="btn btn-primary" />
</form:form>
<a href="/names"><button>Cancel</button></a>  

</body>
</html>