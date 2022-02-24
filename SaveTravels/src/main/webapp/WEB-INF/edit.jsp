<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!-- Required for edit pages -->
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
</head>
<body>
    <h1>Edit Services:</h1>
    <a href="/savetravels">Go Back</a>
<form:form action="/savetravels/update/${itemToEdit.id}" method="post" modelAttribute="itemToEdit">
    <input type="hidden" name="_method" value="put">
<p>
        <form:label path="expense">Expense: </form:label>
        <form:errors path="expense"/>
        <form:input type = "text" path="expense"/>
    </p>
    <p>
        <form:label path="vendor">Vendor: </form:label>
        <form:errors path="vendor"/>
        <form:textarea type="text" path="vendor"/>
    </p>
    <p>
        <form:label path="price">Price: </form:label>
        <form:errors path="price"/>
        <form:input type="number" step="0.01" path="price"/>
    </p>
    <p>
        <form:label path="description">Description: </form:label>
        <form:errors path="description"/>     
        <form:textarea  path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
</body>
</html>