<!-- c:out ;  c:forEach ; c:if-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Travels</title>
</head>
<body>
    <h1>Save Travels</h1>
    <table>
      <thead>
        <tr>
          <th>#ID</th>
          <th>Expense:</th>
          <th>Vendor:</th>
          <th>Price</th>
          <th>Actions: </th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="SaveObject" items="${allSaveServices}">
        <tr>
        <td>${SaveObject.id}</td>
        <td><a href ="/savetravels/${SaveObject.id}">${SaveObject.expense}</a></td>
        <td>${SaveObject.vendor}</td>
        <td>$${SaveObject.price}</td>
        <td> <a href="/savetravels/edit/${SaveObject.id}">Edit</a>
        <a href="/savetravels/delete/${SaveObject.id}">Delete</a></td>
        </tr>
      </c:forEach>
      </tbody>	
    </table>

    <hr>

<form:form action="/savetravels/create" method="post" modelAttribute="saveService">
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