<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html><body>
<h2>Transaction Form</h2>
<form:form method="post" modelAttribute="transaction" action="/spring-mvc-xml/transactions/save">
    <form:hidden path="id"/>
    Description: <form:input path="description"/><br/>
    Amount: <form:input path="amount"/><br/>
    <input type="submit" value="Save"/>
</form:form></body></html>