<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2020
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Chào Bạn! Đây Là Trang Chủ</h2>
    <form action="/find">
        <input type="text" name="find">
        <input type="submit" value="Find">
    </form>
    <br>
    <lable>Result : ${result}</lable>
</body>
</html>
