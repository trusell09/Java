<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!-- c:out ; c:forEach ; c:if -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Dojo</title>
</head>
<body>
    <h1>YO DOJO! ${dojoToShow.name} </h1>
    <a href="/">Go Back</a>
    <table>
        <thead>
        <tr>
            <th>Ninja ID</th>
            <th>First</th>
            <th>Last</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ninjaObject" items="${dojoToShow.ninjas}">
        <tr>
            <td>${ninjaObject.id}</td>
            <td>${ninjaObject.firstName}</td>
            <td>${ninjaObject.lastName}</td>
            <td>${ninjaObject.age}</td>
        </tr>
        </c:forEach>
        </tbody>	
    </table>
</body>
</html>