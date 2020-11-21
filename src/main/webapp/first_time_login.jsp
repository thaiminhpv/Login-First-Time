<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="lms.funix.lab.controller.LoginFirstTimeServlet" %><%--
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
    <% for (int i = 0; i < 3; i++) {%>
        <label>hint1<br><input type="text" class="answers"></label><br>
    <% } %>

    <label>Old password:<br><input type="password" name="<%= LoginFirstTimeServlet.PARAMS_OLD_PASSWORD%>"></label><br>
    <label>New password:<br><input type="password" name="<%= LoginFirstTimeServlet.PARAMS_NEW_PASSWORD%>"></label><br>
    <label>Confirm new password:<br><input type="password" name="<%=LoginFirstTimeServlet.PARAMS_CONFIRM_NEW_PASSWORD%>"></label><br>
    <input type="submit">
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    //TODO: host jquery locally
    let answers = JSON.stringify([...$('input.answers').val()].map(e => e.innerText));

    let input = $('<input>')
                .attr('type', 'hidden')
                .attr('name', 'answers').val(answers);
    $('form').append($(input)).submit();
</script>
<%@include file="components/footer.jsp" %>

</body>
</html>
