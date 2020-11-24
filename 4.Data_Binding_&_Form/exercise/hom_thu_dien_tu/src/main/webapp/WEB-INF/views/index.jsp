<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form:form action="/show" modelAttribute="homthu" method="post">
    <p>Languages : <span><form:select type="text" path="languages" items="${listLanguages}"/></span></p>
    <p>Page Size :
        <span>Show</span>
        <span><form:select type="text" path="pageSize" items="${pageSize}"/></span>
        <span>email per page</span>
    </p>
    <p>Spams Filter :
        <input type="checkbox" name="spamsFilter" checked="checked" value="true"/>
        <lable>enable per page</lable>
    </p>
    <p>Singature :</p>
    <textarea name="signature" id="" cols="30" rows="10" ></textarea>
    <br>
    <input type="submit" value="Update"/>
</form:form>
<input type="submit" value="Close"/>
</body>
</html>
