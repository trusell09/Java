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
<title>Menu Items</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <h1>All the Menu Items!!!!!!!!</h1>
    ${allMenuItems}

    <table>
      <thead>
        <tr>
          <th>#ID</th>
          <th>Name</th>
          <th>Dish</th>
          <th>Price</th>
          <th>Actions: </th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="MenuObject" items="${allMenuItems}">
        <tr>
        <td>${MenuObject.id}</td>
        <td><a href ="/menuitems/${MenuObject.id}">${MenuObject.name}</a></td>
        <td>${MenuObject.dishType}</td>
        <td>$${MenuObject.price}</td>
        <td> <a href="/menuitems/edit/${MenuObject.id}">Edit</a>
        <a href="/menuitems/delete/${MenuObject.id}">Delete</a></td>
        </tr>
      </c:forEach>
      </tbody>	
    </table>

    <hr>


<form:form action="/menuitem/create" method="post" modelAttribute="menuItem">
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