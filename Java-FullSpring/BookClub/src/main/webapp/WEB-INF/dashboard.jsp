<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${name}'s Book Dashboard"/></title>
</head>
<body>

	<h1><c:out value="Welcome, ${name}"/></h1>
	
	<a href="/logout">Logout</a>
	
	<a href="/books/new">Add a book to my shelves</a>
	
	<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author Name</th>
      <th scope="col">Posted By</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${allBooks}" var="book">
    <tr>
			<td>${book.id}</td>
			<td><a href="/books/${book.id}">${book.title}</a></td>
			<td>${book.authorName}</td>
			<td>${book.postedBy}</td>
    </tr>
	</c:forEach>
  </tbody>
</table>

</body>
</html>