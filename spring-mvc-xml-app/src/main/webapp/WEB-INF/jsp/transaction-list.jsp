<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>Transaction List</h2>
<a href="transactions/new">Add Transaction</a>
<table border="1">
<tr><th>ID</th><th>Description</th><th>Amount</th><th>Actions</th></tr>
<c:forEach var="txn" items="${list}">
<tr><td>${txn.id}</td><td>${txn.description}</td><td>${txn.amount}</td>
<td><a href="transactions/edit/${txn.id}">Edit</a> | <a href="transactions/delete/${txn.id}">Delete</a></td></tr>
</c:forEach>
</table></body></html>