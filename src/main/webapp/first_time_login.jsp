<%--
  Created by IntelliJ IDEA.
  User: Thaiminhpv PC
  Date: 21-Nov-20
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First Time Login</title>
</head>
<body>

<%@include file="components/header.jsp" %>
<form action="${pageContext.request.contextPath}/first_time_login" method="post">
    <label>hint1<br><input type="text" name="hint1"></label><br>
    <label>hint2<br><input type="text" name="hint2"></label><br>
    <label>hint3<br><input type="text" name="hint3"></label><br>
    <label>New password:<br><input type="password" name="new_password"></label><br>
    <label>Confirm new password:<br><input type="password" name="confirm_new_password"></label><br>
    <input type="submit">
</form>
<%@include file="components/footer.jsp" %>

</body>
</html>
