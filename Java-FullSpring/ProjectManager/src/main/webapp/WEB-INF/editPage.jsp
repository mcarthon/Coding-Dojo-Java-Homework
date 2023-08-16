<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="Edit ${project.title}" /></title>
</head>
<body>

	<h1>Edit Project: <c:out value="${project.title}"/></h1>
	
	<form:form action="/projects/edit/${project.id}" method="patch" modelAttribute="project">
	
	<p><c:out value="${errors}"/></p>
	
    <div class="form-group">
        <label>Title: </label>
        <form:input type="text" path="title" class="form-control" value="${project.title}"/>
        <%-- <form:errors path="title" class="text-danger" />--%>
        
    </div>
    
    <div class="form-group">
        <label>Description: </label>
        <form:input type="text" path="description" class="form-control" value="${project.description}"/>
        <%-- <form:errors path="authorName" class="text-danger" />--%>
    </div>
    
    <div class="form-group">
        <label>Due Date: </label>
        <form:input type="date" path="dueDate" class="form-control" value="${newDueDate}"/>
        <%-- <form:errors path="myThoughts" class="text-danger" />--%>
    </div>    
    
    <input type="submit" value="Edit Project" class="btn btn-primary" />
    
</form:form>
<a href="/projects/${project.id}"><button>Cancel</button></a>  

</body>
</html>