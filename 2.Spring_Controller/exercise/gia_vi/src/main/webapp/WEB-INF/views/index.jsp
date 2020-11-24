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
<div class="container">
    <form action="">
        <input type="checkbox" name="condiment" id="lettuce" value="lettuce">
        <lable for="lettuce">Lettuce</lable><br>
        <input type="checkbox" name="condiment" id="tomato" value="tomato">
        <lable for="tomato">Tomato</lable><br>
        <input type="checkbox" name="condiment" id="mustard" value="mustard">
        <lable for="mustard">Mustard</lable><br>
        <input type="checkbox" name="condiment" id="sprouts" value="sprouts">
        <lable for="sprouts">Sprouts</lable><br>
        <hr>
        <input type="submit" value="Save">
    </form>
    <lable>List is : ${list}</lable>
</div>
</body>
</html>
