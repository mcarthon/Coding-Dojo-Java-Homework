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
<title><c:out value="${babyname.name} Page" /></title>
</head>
<body>

<a href="/names">Home</a>

<a href="/logout">log out</a>

	<h1><c:out value="${babyname.name}" /></h1>
	
	<h2><c:out value="(added by ${name})" /></h2>
	
	<p><c:out value="Gender: ${babyname.gender}" /></p>
	
	<p><c:out value="Origin: ${babyname.origin}" /></p>
	
	<c:if test="${babyname.getUsers ().contains ( currentUser ) }">
		
			<p>You voted for this name</p>
		
		</c:if>													
		
		<c:if test="${!babyname.getUsers ().contains ( currentUser ) }">
		
			<form action="/names/upvote/show/${user_id}/${babyname.id}" method="post"> 
			
			<input type="submit" value="upvote"/>
		
			</form>
		
		</c:if>
		
		<p><c:out value="Meaning: ${babyname.meaning}" /></p>
		
		<a href="/names/edit/${babyname.id}"><button>Edit</button></a>

</body>
</html>