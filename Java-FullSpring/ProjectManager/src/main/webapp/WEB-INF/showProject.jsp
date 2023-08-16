<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${project.title}"/></title>
</head>
<body>

	<a href="/projects">Back to Dashboard</a>

	<h1>Project Details</h1>
	
	<c:choose>
	
		<c:when test="${user_id == project.teamLead.id}">
		
			<p><c:out value="Project: ${project.title}"/></p>
			
			<p><c:out value="Description: ${project.description}"/></p>
			
			<p><fmt:formatDate pattern = "M/d/yyyy" value = "${project.dueDate}" /></p>
			
			<a href="/projects/${project.id}/tasks">See Tasks!</a>
			
			<form action="/projects/${project.id}" method="post">
			
				<input type="hidden" name="_method" value="delete"/>
				
				<input type="submit" value="Delete" />
			
			</form>
		
		</c:when>
		
		<c:otherwise>
		
			<p><c:out value="Project: ${project.title}"/></p>
			
			<p><c:out value="Description: ${project.description}"/></p>
			
			<p><fmt:formatDate pattern = "M/d/yyyy" value = "${project.dueDate}" /></p>
			
			<a href="/projects/${project.id}/tasks">See Tasks!</a>
		
		</c:otherwise>
	
	</c:choose>
	
	
	
</body>
</html>