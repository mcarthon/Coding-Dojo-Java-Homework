<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${expense.expenseName}"/></title>
</head>
<body>

<a href="/">All Expenses</a>

	<h1><c:out value="${expense.expenseName}"/></h1>
	<p><c:out value="${expense.vendor}"/></p>
	<p><c:out value="${expense.amount}" /></p>
	<p><c:out value="${expense.description}" /></p>

</body>
</html>