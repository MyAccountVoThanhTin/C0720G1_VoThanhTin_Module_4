<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/24/2020
  Time: 8:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hello <World></World></h2>
<div class="container">
    <form action="/caculator" method="post">
        <input type="text" name="num1">
        <input type="text" name="num2">
        <hr>
        <input type="submit" name="caculator" value="Addition(+)">
        <input type="submit" name="caculator" value="Subtraction(-)">
        <input type="submit" name="caculator" value="Multiplication(X)">
        <input type="submit" name="caculator" value="Division(/)">
    </form>
    <lable>Result ${result}</lable>
</div>
</body>
</html>
