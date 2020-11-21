<%--
  Created by IntelliJ IDEA.
  User: Thaiminhpv PC
  Date: 21-Nov-20
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/" method="post">
    <label>
        Username:
        <br>
        <input type="text" name="username">
    </label>
    <br>
    <label>
        Password:
        <br>
        <input type="password" name="password">
    </label>
    <br>
    <input type="submit">
</form>

</body>
</html>
