<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie Site!</title>
</head>
<body>
	<h1><c:out value = "${movie}"></c:out></h1>
	<p>Released on: <c:out value = "${rd}"></c:out></p>
	<img height = "400px" src = "<c:out value = "${imageUrl}"/>"/>



	<table>
		<thead>
			<tr>
				<th>First</th>
				<th>Last</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="actorObject" items="${actors}">
			<tr>
			<td>${actorObject.firstName}</td>
			<td>${actorObject.lastName}</td>
			<td>${actorObject.age}</td>
			</tr>
		</c:forEach>
		</tbody>	
	</table>
</body>
</html>