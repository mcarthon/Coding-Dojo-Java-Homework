<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
</head>
<body>

	<h1> Send an Omikuji </h1>

	<form action="/submit" method="post">
	
		<div>
		<label> Pick any number from 5 to 25 </label>
		<input type="number" name="number"/>
		</div>
		
		<div>
		<label> Enter the name of any city </label>
		<input type="text" name="city"/>
		</div>
		
		<div>
		<label> Enter the name of any real person </label>
		<input type="text" name="name"/>
		</div>
		
		<div>
		<label> Enter a professional endeavor or hobby </label>
		<input type="text" name="hobby"/>
		</div>
		
		<div>
		<label> Enter any type of living thing </label>
		<input type="text" name="livingTing"/>
		</div>
		
		<div>
		<label> Say something nice to someone </label>
		<textarea name="quote"></textarea>
		</div>
		
		<div>
		<p> Send and show a friend </p>
		</div>
		
		<input type="submit" value="Send"/>
	
	</form>

</body>
</html>