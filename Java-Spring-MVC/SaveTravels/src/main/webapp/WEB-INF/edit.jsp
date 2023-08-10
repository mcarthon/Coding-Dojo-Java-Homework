<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit <c:out value="${expense.expenseName}"/></title>
</head>
<body>

	<form:form action="/edit/${expense.id}" method="post" modelAttribute="expense">
	<input type="hidden" name="_method" value="patch"/>
    <div class="form-group">
        <label>Expense Name: </label>
        <form:input type="text" path="expenseName" class="form-control" value="${expense.expenseName}"/>
        <form:errors path="expenseName" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Vendor Name: </label>
        <form:input type="text" path="vendor" class="form-control" value="${expense.vendor}"/>
        <form:errors path="vendor" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Amount: </label>
        <form:input type="text" path="amount" class="form-control" value="${expense.amount}"/>
        <form:errors path="amount" class="text-danger" />
    </div>
    <div class="form-group">
        <label>Description: </label>
        <form:input type="text" path="description" class="form-control" value="${expense.description}"/>
        <form:errors path="description" class="text-danger" />
    </div>    
    <input type="submit" value="Edit Expense" class="btn btn-primary" />
</form:form>

</body>
</html>