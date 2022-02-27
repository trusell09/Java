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
<title>One Book</title>
</head>
<body>
    <div>
        <h1>Hello, ${loggedInUser.userName}</h1>
        <a href="/books">Go Back</a>
        <h1>${book.title}</h1>
        <h2>
            <span style="color:blue;">${book.user.userName}</span> 
            read 
            <span style="color:orange;">${book.title}</span> 
            by <span style="color:red;">${book.author}</span>
        </h2>
        <p></p>
        <h3>Here are ${book.user.userName}'s thoughts:</h3>
        <hr>
        <h3>${book.thought}</h3>
        <c:if test="${loggedInUser.id == book.user.id}">
            <a href="/books/edit/${book.id}">Edit</a>  
            <a href="/books/delete/${book.id}">Delete</a>
        </c:if>
        </div>
</body>
</html>