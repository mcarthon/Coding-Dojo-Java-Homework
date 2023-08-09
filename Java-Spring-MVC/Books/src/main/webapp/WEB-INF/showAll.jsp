<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
</head>
<body>

<c:forEach var="book" items="${books}">

	<a href="/show/${book.id}"> <c:out value="${book.title}" /> </a>

	<p> Description: <c:out value="${book.description}" /> </p>
	
	<p> Language: <c:out value="${book.language}" /> </p>
	
	<p> Number of Pages: <c:out value="${book.numberOfPages}" /> </p>

</c:forEach>

</body>
</html>