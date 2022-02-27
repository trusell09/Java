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
<title>Edit Book</title>
</head>
<body>
  <div>
    <h1>Edit Book:</h1>
    <a href="/books">Go Back</a>
        <form:form action="/books/update/${bookToEdit.id}" method="post" modelAttribute="bookToEdit">
                        <input type="hidden" name="_method" value="put">
                        <p>
                            <form:label path="title">Title: </form:label>
                            <form:errors path="title"/>
                            <form:input type="text" path="title"/>
                        </p>
                        <p>
                            <form:label path="author">Author:</form:label>
                            <form:errors path="author"/>
                            <form:input type="text" path="author" />
                        </p>
                        <p>
                            <form:label path="thought">Thoughts: </form:label>
                            <form:errors path="thought"/>
                            <form:textarea type="number" path="thought"/>
                        </p>
                        <p>
                            <form:input type="hidden" path="user" value="${loggedInUser.id}"/>
                        </p>
                        <div>
                        <a href="/books/delete/${bookToEdit.id}">Delete</a>
                        </div>
                        <hr>
                        <input type="submit" value="Submit" /> 
        </form:form>
    </div>
</body>
</html>