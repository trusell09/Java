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
<title>Home</title>
</head>
<body>
    <div>
        <h1>BOOK CLUB!</h1>
        <hr>
        <div>
            <div>
                <h1>Register:</h1>
                <form:form action="/register" method="post" modelAttribute="newUser">
                    <div>
                        <form:label path="userName">Name:</form:label>
                        <form:errors path="userName"/>
                        <form:input path="userName" type="text"/>
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
                    <input type="submit" value="Submit"/>
                </form:form>   
            </div>
            <hr>
            <div>
                <h1>Login:</h1>
                <form:form action="/login" method="post" modelAttribute="newLogin">
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
            </div>
        </div>
    </div>
</body>
</html>