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
<title><c:out value="Tasks for ${project.title}" /></title>
</head>
<body>

	<h1><c:out value="Project: ${project.title}" /></h1>
	
	<a href="/projects">Back to Dashboard</a>
	
	<p><c:out value="Project Lead: ${project.teamLead.name}"/></p>
	
	<form:form action="/projects/${projectId}/tasks" method="post" modelAttribute="task">
	
		<form:input type="text" path="description" />
		<form:errors path="description"/>
		
		<input type="submit" value="Add Task"  />
	
	</form:form>
	
	<c:forEach items="${project.tasks}" var="thisTask" >
	
		<h6><c:out value="Added by ${thisTask.author.name} at " /><fmt:formatDate pattern = " h:mm" value = "${thisTask.createdAt}"/> on <fmt:formatDate pattern = "MMM d" value = "${thisTask.createdAt}"/></h6>
		
		<p><c:out value="${thisTask.description}"/></p>
	
	</c:forEach>

</body>
</html>