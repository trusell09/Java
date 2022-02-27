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
<title>User</title>
</head>
<body>
    <div>
        <h1>Hello, ${loggedInUser.userName}!</h1>
        <h3>${user.userName}'s thoughts on books.</h3>
        <a href="/books">Go Back</a>
        <table>
            <thead>
                <tr>
                    <th>#ID</th>
                    <th>Title:</th>
                    <th>Author Name:</th>
                    <th>Posted By:</th>
                    <th>Actions: </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items='${ allBooks }' var='bookObj'>
                    <c:if test="${user.id == bookObj.user.id}">
                    <tr>
                        <th>${bookObj.id}</th>
                        <td><a href="/books/${bookObj.id}">${bookObj.title}</a></td>
                        <td>${bookObj.author}</td>
                        <td><a href="/books/user/${bookObj.user.id}">${bookObj.user.userName}</a></td>
                        <td>
                            <c:if test="${loggedInUser.id == bookObj.user.id}">
                            <a href="/books/edit/${bookObj.id}">Edit</a> 
                            <a href="/books/delete/${bookObj.id}">Delete</a>
                            </c:if>
                        </td>
                    </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>