<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Service</title>
</head>
<body>
    <h1>Expense Details:</h1>
        <h2>Expense: ${saveServiceToShow.expense}</h2>
        <h2>Vendor: ${saveServiceToShow.vendor}</h2>
        <h2>Price: $${saveServiceToShow.price}</h2>
        <h2>Description: ${saveServiceToShow.description}</h2>
    <a href="/savetravels">Go Back</a>
</body>
</html>