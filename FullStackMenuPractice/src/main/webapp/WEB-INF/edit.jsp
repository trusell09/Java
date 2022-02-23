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
    <h1>Edit Menu Item Below:</h1>

<form:form action="/menuitems/update/${itemToEdit.id}" method="post" modelAttribute="itemToEdit">
    <input type="hidden" name="_method" value="put">
<p>
        <form:label path="name">Name: </form:label>
        <form:errors path="name"/>
        <form:input type = "text" path="name"/>
    </p>
    <p>
        <form:label path="dishType">Dish Type: </form:label>
        <form:errors path="dishType"/>
        <form:textarea type="text" path="dishType"/>
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