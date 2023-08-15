<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Book</title>
</head>
<body>

	<h1>Add a book to Your Shelf</h1>
	
	<a href="/books">back to the shelves</a>

	<form:form action="/books" method="post" modelAttribute="newBook">
    <div class="form-group">
        <label>Title: </label>
        <form:input type="text" path="title" class="form-control" />
        <form:errors path="title" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Author Name: </label>
        <form:input type="text" path="authorName" class="form-control" />
        <form:errors path="authorName" class="text-danger" />
    </div>
    
    <form:input type="hidden" path="postedBy" value="${name}" class="form-control" />
    
    <form:input type="hidden" path="user.id" value="${user_id}" class="form-control" />
    
    <div class="form-group">
        <label>My Thoughts: </label>
        <form:input type="text" path="myThoughts" class="form-control" />
        <form:errors path="myThoughts" class="text-danger" />
    </div>    
    <input type="submit" value="Add New Book" class="btn btn-primary" />
</form:form>

</body>
</html>