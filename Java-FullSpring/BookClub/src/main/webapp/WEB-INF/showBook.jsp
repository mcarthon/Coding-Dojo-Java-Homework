<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${book.title}"/></title>
</head>
<body>

	<a href="/books">back to the shelves</a>

	<h1><c:out value="${book.title}" /></h1>
	
	<c:choose>
	
		<c:when test="${user_id == book.user.id}">
		
			<p><c:out value="You read ${book.title} by ${book.authorName}." /></p>
			
			<p>Here are your thoughts:</p>
			
			<p><c:out value="${book.myThoughts}"/></p>
			
			<a href="/books/edit/${book.id}"><button>Edit</button></a>
			
			<form action="/books/${book.id}" method="post">
			
				<input type="hidden" name="_method" value="delete"/>
				
				<input type="submit" value="Delete" />
			
			</form>
		
		</c:when>
		
		<c:otherwise>
		
			<p><c:out value="${book.postedBy} read ${book.title} by ${book.authorName}." /></p>
		
			<p><c:out value="Here are ${book.postedBy}'s thoughts:" /></p>
			
			<p><c:out value="${book.myThoughts}"/></p>
		
		</c:otherwise>
	
	</c:choose>
	
	
	
</body>
</html>