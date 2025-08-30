<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html><body>
<h2>User Form</h2>
<form:form method="post" modelAttribute="users" action="/spring-mvc-xml/users/save">
    <form:hidden path="id"/>
    Name: <form:input path="name"/><br/>
    Email: <form:input path="email"/><br/>
    <input type="submit" value="Save"/>
</form:form></body></html>