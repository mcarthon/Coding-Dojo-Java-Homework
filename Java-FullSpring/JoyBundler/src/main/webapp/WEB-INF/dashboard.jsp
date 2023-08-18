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
<title>Baby Names Dashboard</title>
</head>
<body>

	<h1><c:out value="Hello, ${name}. Here are some name suggestions..." /></h1>
	
	<a href="/logout">log out</a>
	
	<a href="/names/new" ><button>new name</button></a>
	
	<h3>Baby Names</h3>
	
	<table>
  		
  		<thead>
    	
    		<tr>
      	
      			<th>Vote</th>
      			
      			<th>Name</th>
      			
      			<th>Gender</th>
      			
      			<th>Origin</th>
      			
      			<th>Votes</th>
		
			</tr>
  
  		</thead>
  
  		<tbody>
  		
  		<c:forEach items="${allBabyNames}" var ="babyname" >
    		
    		<tr>
      
      			<td>
      			
      				<c:if test="${!babyname.getUsers ().contains ( currentUser ) }">
		
						<form action="/names/upvote/${user_id}/${babyname.id}" method="post"> 
			
						<input type="submit" value="upvote"/>
		
						</form>
		
					</c:if>													
		
					<c:if test="${babyname.getUsers ().contains ( currentUser ) }">
		
						<form action="/names/downvote/${user_id}/${babyname.id}" method="post"> 
			
						<input type="submit" value="downvote"/>
		
						</form>
		
					</c:if>
		
				</td>
     
      			<td>
      			
      				<a href="/names/${ babyname.id }"><c:out value="${babyname.name}" /></a>
      			
      			</td>
      			
      			<td>
      			
      				<c:out value="${babyname.gender}" />
      			
      			</td>
      			
      			<td>
      			
      				<c:out value="${babyname.origin}" />		
      			
      			</td>
      			
      			<td>
      			
      				<c:out value="${babyname.users.size()}" />		
      			
      			</td>
    
    		</tr>
    		
    	</c:forEach>
  
  		</tbody>

	</table>
		
</body>
</html>