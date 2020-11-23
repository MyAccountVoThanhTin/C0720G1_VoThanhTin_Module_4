
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/tinh">
    <lable>Nhap So Tien Chuyen Doi : </lable>
    <br>
    <input type="text" name="number" id="number">
    <select name="vndUsd">
      <option value="vnd">VND</option>
      <option value="usd">USD</option>
    </select>
    <input type="submit" value="Tinh">
  </form>
  </body>
</html>
