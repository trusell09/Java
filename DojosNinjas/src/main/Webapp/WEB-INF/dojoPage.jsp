<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Menu</title>
</head>
<body>
    <h1>Yo! Please add a dojo using the form below:</h1>
    <a href="/ninja/add">Add Ninja</a>
    <form:form action="/dojos/create" method="post" modelAttribute="dojo">
        <p>
            <form:label path="name">Dojo City:</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>    
</body>
</html> 
