<%@ page import="static lms.funix.lab.view.View.Login.Params.PASSWORD" %>
<%@ page import="static lms.funix.lab.view.View.Login.Params.USER_ID" %><%--
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
<%@include file="components/header.jsp" %>
<form action="${pageContext.request.contextPath}/" method="post">
    <label>
        User ID:
        <br>
        <input type="text" name="<%=USER_ID%>">
    </label>
    <br>
    <label>
        Password:
        <br>
        <input type="password" name="<%=PASSWORD%>">
    </label>
    <br><input type="submit"><br>
    <a href="first_time_login">Forgot password</a>
</form>
<%@include file="components/footer.jsp" %>
</body>
</html>
