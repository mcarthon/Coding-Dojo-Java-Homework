<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="Edit ${babyname.name}" /></title>
</head>
<body>

<a href="/names">Home</a>

<a href="/logout">log out</a>

	<h1><c:out value="Change ${babyname.name}"/></h1>
	
	<form:form action="/names/edit/${babyname.id}" method="patch" modelAttribute="updateBabyName">	
	
	<form:hidden path="id" value="${babyname.id}" />
    <div class="form-group">
        <form:hidden path="name" value="${babyname.name}" class="form-control" />
    </div>
    
    <div class="form-group">
        <label>Typical Gender: </label>
        <form:select path="gender" class="form-control" >
        
        	<form:option value="Male" selected="${babyname.gender == 'Male'}" >Male</form:option>
        	
        	<form:option value="Female" selected="${babyname.gender == 'Female'}">Female</form:option>
        	
        	<form:option value="Neutral" selected="${babyname.gender == 'Neutral'}" >Neutral</form:option>
        
        </form:select>
        <form:errors path="gender" class="text-danger" />
    </div>
    
    <div class="form-group">
        <label>Origin: </label>
        <form:input type="text" path="origin" value="${babyname.origin}" class="form-control" />
        <form:errors path="origin" class="text-danger" />
    </div>  
    
    <div class="form-group">
        <label>Meaning: </label>
        <form:input type="text" path="meaning" value="${babyname.meaning}"  class="form-control" />
        <form:errors path="meaning" class="text-danger" />
    </div> 
    
    
    <input type="submit" value="Edit Baby Name" class="btn btn-primary" />
</form:form>
<a href="/names"><button>Cancel</button></a>  

<form action="/names/${babyname.id}" method="post">
	<input type="hidden" name="_method" value="delete"/>
	<input type="submit" value="Delete" />
</form>


</body>
</html>