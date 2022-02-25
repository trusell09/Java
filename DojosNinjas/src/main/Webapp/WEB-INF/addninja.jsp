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
<title>Add Ninja</title>
</head>
<body>
    <a href="/">Go Back</a>
    <h1>Add Ninja Below:</h1>
    <form:form action="/ninjas/create" method="post" modelAttribute="ninja">
        <div>
            <form:label path="firstName">First Name:</form:label>
            <form:errors path="firstName"/>
            <form:input path="firstName"/>
        </div>
        <div>
            <form:label path="lastName">Last Name:</form:label>
            <form:errors path="lastName"/>
            <form:input path="lastName"/>
        </div>
        <div>
            <form:label path="age">Age:</form:label>
            <form:errors path="age"/>
            <form:input path="age" type="number"/>
        </div>
        <div>
            <form:label path="dojo">The Ninja's Dojo:</form:label>
            <form:errors path="dojo"/>
            <form:select path="dojo" id="">
                <c:forEach items="${alldojos}" var="dojoObj">
                    <option value="${dojoObj.id}">${dojoObj.name}</option>
                </c:forEach>
            </form:select>
        </div> 
        <input type="submit" value="Submit"/>
    </form:form>    
</body>
</html>