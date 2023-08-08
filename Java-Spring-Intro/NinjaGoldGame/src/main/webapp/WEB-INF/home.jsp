<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<div>
	
		<p> Your Gold: <c:out value="${ goldCount }" /> </p>
		
		<a href="/reset"> <button> Reset </button> </a>
	
	</div>
	
	<div class="form-container">
	
		<div class="location">
		
			<p> Farm </p>
			
			<p> (earns 10-20 gold) </p>
			
			<form action="/add-money" method="post">
			
				<input type="hidden" name="location" value="farm"/>
				
				<input type="submit" value="Find Gold!"/>
				
			</form>
		
		</div>
		
		<div class="location">
		
			<p> Cave </p>
			
			<p> (earns 5-10 gold) </p>
			
			<form action="/add-money" method="post">
			
				<input type="hidden" name="location" value="cave"/>
				
				<input type="submit" value="Find Gold!"/>
				
			</form>
		
		</div>
		
		<div class="location">
		
			<p> House </p>
			
			<p> (earns 2-5 gold) </p>
			
			<form action="/add-money" method="post">
			
				<input type="hidden" name="location" value="house"/>
				
				<input type="submit" value="Find Gold!"/>
				
			</form>
		
		</div>
		
		<div class="location">
		
			<p> Quest </p>
			
			<p> (earns/takes 0-50 gold) </p>
			
			<form action="/add-money" method="post">
			
				<input type="hidden" name="location" value="quest"/>
				
				<input type="submit" value="Find Gold!"/>
				
			</form>
		
		</div>
		
		<div class="location">
		
			<p> Spa </p>
			
			<p> (takes 5-20 gold) </p>
			
			<form action="/add-money" method="post">
			
				<input type="hidden" name="location" value="spa"/>
				
				<input type="submit" value="Find Gold!"/>
				
			</form>
		
		</div>
	
	</div>
	
	<div>
	
		<p> Activities: </p>
	
		<textarea> <c:out value="${ log }"/> </textarea>
	
	</div>

</body>
</html>