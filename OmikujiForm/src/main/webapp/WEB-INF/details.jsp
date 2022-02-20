<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <h1>Here's Your Omijkuji</h1>
    <p>In <%= session.getAttribute ("pick_num") %> years, you will live in <%= session.getAttribute ("city") %> with <%= session.getAttribute ("real_person") %>
    as your roommate, <%= session.getAttribute ("hobby") %> for a living. The next time you see a <%= session.getAttribute ("living_thing") %>, you will have good luck. Also, <%= session.getAttribute ("fun_fact") %>.
    </p>
    <a href="/">Go Back</a>
</body>
</html>