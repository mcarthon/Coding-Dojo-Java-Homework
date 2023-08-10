<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Expenses</title>
</head>
<body>

<a href="/new">Add New Expense</a>

	<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Expense Name</th>
      <th scope="col">Vendor Name</th>
      <th scope="col">Amount</th>
      <th scope="col">Actions</th>
      
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${allExpenses}" var="expense">
    <tr>
			<td><a href="/${expense.id}">${expense.expenseName}</a></td>
			<td>${expense.vendor}</td>
			<td>${expense.amount}</td>
			<td><a href="/edit/${expense.id}"><button>Edit</button></a>
			<form action="/${expense.id}" method="post">
			<input type="hidden" name="_method" value="delete"/>
			<input type="submit" value="Delete"/>
			</form>
			</td>
    </tr>
	</c:forEach>
  </tbody>
</table>

</body>
</html>