<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

    <h1> Omikuji !!!!!!</h1>
    <form action="/process_form" method="post">
        <div>
            <label for="">Pick any number from 5 to 25 </label>
            <input type="number" name="pick_num">
        </div>
        <div>
            <label for="">Enter the name of any city </label>
            <input type="text" name="city">
        </div>
        <div>
            <label for="">Enter the name of any real person </label>
            <input type="text" name="real_person">
        </div>
        <div>
            <label for="">Enter professional endeavor or hobby </label>
            <input type="text" name="hobby">
        </div>
        <div>
            <label for="">Enter any type of living thing </label>
            <input type="text" name="living_thing">
        </div>
        <div>
            <label for="">Say something nice to someone: </label>
            <textarea cols="20" rows="10" name="fun_fact"></textarea>
        </div>
        <h2>Send and show a friend</h2>
        <input type="submit" value="Submit">
        </form>
</body>
</html>