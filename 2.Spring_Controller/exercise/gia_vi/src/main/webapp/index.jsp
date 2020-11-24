<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/23/2020
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div class="container">
    <form action="/save">
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
  </div>
  </body>
</html>
