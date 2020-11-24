<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<lable>Languages : ${homthu.languages}</lable>
<br>
<lable>Page Size : ${homthu.pageSize}</lable>
<br>
<lable>Spam Filter : ${homthu.spamsFilter}</lable>
<br>
<lable>Singnature : ${homthu.signature}</lable>
<form action="/homeback" method="get">
    <button>Ok</button>
</form>
</body>
</html>
