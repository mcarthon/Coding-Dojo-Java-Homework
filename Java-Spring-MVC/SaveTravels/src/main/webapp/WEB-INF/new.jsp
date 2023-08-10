<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Expense</title>
</head>
<body>

	<form:form action="/new" method="post" modelAttribute="expense">
    <div class="form-group">
        <label>Expense Name: </label>
        <form:input type="text" path="expenseName" class="form-control" />
        <form:errors path="expenseName" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Vendor Name: </label>
        <form:input type="text" path="vendor" class="form-control" />
        <form:errors path="vendor" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Amount: </label>
        <form:input type="text" path="amount" class="form-control" />
        <form:errors path="amount" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Description: </label>
        <form:input type="text" path="description" class="form-control" />
        <form:errors path="description" class="text-danger" />
    </div>    
    <input type="submit" value="Add Expense" class="btn btn-primary" />
</form:form>

</body>
</html>