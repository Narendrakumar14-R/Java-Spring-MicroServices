<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>User List</h2>
<a href="users/new">Add User</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
<c:forEach var="user" items="${list}">
<tr><td>${user.id}</td><td>${user.name}</td><td>${user.email}</td>
<td><a href="users/edit/${user.id}">Edit</a> | <a href="users/delete/${user.id}">Delete</a></td></tr>
</c:forEach>
</table></body></html>