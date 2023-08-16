<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Project</title>
</head>
<body>

	<h1>Create a Project</h1>

	<form:form action="/projects" method="post" modelAttribute="newProject">
    <div class="form-group">
        <label>Project Title: </label>
        <form:input type="text" path="title" class="form-control" />
        <form:errors path="title" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Project Description: </label>
        <form:input type="text" path="description" class="form-control" />
        <form:errors path="description" class="text-danger" />
    </div>
    
    <div class="form-group">
        <label>Due Date: </label>
        <form:input type="date" path="dueDate" class="form-control" />
        <form:errors path="dueDate" class="text-danger" />
    </div>  
    
    
    <input type="submit" value="Add New Book" class="btn btn-primary" />
</form:form>
<a href="/projects"><button>Cancel</button></a>  

</body>
</html>