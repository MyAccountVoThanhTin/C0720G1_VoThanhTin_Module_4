<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/20/2020
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<div class="container-fluid">
    <table class="table table-striped" id="tableCustomer" style="width: 100%">
        <thread>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
            </tr>
        </thread>
        <tbody>
            <c:forEach var="listCustomer" items="${listCustomer}">
                <tr>
                    <td><c:out value="${listCustomer.id}"/></td>
                    <td><c:out value="${listCustomer.name}"/></td>
                    <td><c:out value="${listCustomer.email}"/></td>
                    <td><c:out value="${listCustomer.address}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
