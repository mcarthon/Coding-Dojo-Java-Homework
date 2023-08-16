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
<title><c:out value="${name}'s Project Manager Dashboard"/></title>
</head>
<body>

	<h1><c:out value="Welcome, ${name}!"/></h1>
	
	<a href="/logout">Logout</a>
	
	<a href="/projects/new"><button>+ new project</button></a>
	
	<h4>All Projects</h4>
	<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${notMyProjects}" var="project">
    <tr>
			<td><a href="/projects/${project.id}">${project.title}</a></td>
			<td>${project.teamLead.name}</td>
			<td><fmt:formatDate pattern = "MMMM dd" value = "${project.dueDate}" /></td>
			<td><a>Join Team</a></td>
    </tr>
	</c:forEach>
  </tbody>
</table>

<h4>Your Projects</h4>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Project</th>
      <th scope="col">Team Lead</th>
      <th scope="col">Due Date</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${myProjects}" var="project">
    <tr>
			<td><a href="/projects/${project.id}">${project.title}</a></td>
			<td>${project.teamLead.name}</td>
			<td><fmt:formatDate pattern = "M-dd" value = "${project.dueDate}" /></td>
			<td>Actions</td>
    </tr>
	</c:forEach>
  </tbody>
</table>

</body>
</html>