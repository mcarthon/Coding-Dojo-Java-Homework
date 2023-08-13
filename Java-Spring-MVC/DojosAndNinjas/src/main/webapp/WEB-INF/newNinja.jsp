<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ page isErrorPage="true" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>

	<h2> New Ninja </h2>	
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
	
		<label>Dojo Location: </label>
		<form:select path="dojo">
		
			<c:forEach items="${allDojos}" var="oneDojo">
			
				<option value="${oneDojo.id}"><c:out value="${oneDojo.name}"/></option>
			
			</c:forEach>
		
		</form:select>
	
		<label> First Name: </label>
		<form:input path="firstName" type="text"/>
		<form:errors path="firstName" />
		
		<label> Last Name: </label>
		<form:input path="lastName" type="text"/>
		<form:errors path="lastName" />
		
		<label> Age: </label>
		<form:input path="age" type="text"/>
		<form:errors path="age" />
		
		<input type="submit" value="Add New Ninja" />
	
	</form:form>

</body>
</html>