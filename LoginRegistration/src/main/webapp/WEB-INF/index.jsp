<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c:out ; c:forEach ; c:if -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    <!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>   

    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
</head>
<body>
    <h1>Login and Registration</h1>
    <form:form action="/register" method="post" modelAttribute="newUser">
        <div>
            <form:label path="userName">User Name:</form:label>
            <form:errors path="userName"/>
            <form:input path="userName"/>
        </div>
        <div>
            <form:label path="email">Email:</form:label>
            <form:errors path="email"/>
            <form:input path="email" type="email"/>
        </div>
        <div>
            <form:label path="password">Password:</form:label>
            <form:errors path="password"/>
            <form:input path="password" type="password"/>
        </div>
        <div>
            <form:label path="confirm">Confirm Password:</form:label>
            <form:errors path="confirm"/>
            <form:input path="confirm" type="password"/>
        </div>
        </div> 
        <input type="submit" value="Submit"/>
    </form:form>   
    <h1>Login</h1>
    <form:form  method="post" action="/login" modelAttribute="newLogin">
        <div>
            <form:label path="email">Email:</form:label>
            <form:errors path="email"/>
            <form:input path="email" type="email"/>
        </div>
        <div>
            <form:label path="password">Password:</form:label>
            <form:errors path="password"/>
            <form:input path="password" type="password"/>
        </div>
        <input type="submit" value="Login"/>
    </form:form>    
</body>
</html>