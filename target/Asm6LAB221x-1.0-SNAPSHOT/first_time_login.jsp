<%@ page import="static lms.funix.lab.view.View.LIST_HINT_QUESTIONS" %>
<%@ page import="static lms.funix.lab.view.View.LoginFirstTime.Params.*" %><%--
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
<h1>Error: <%=request.getAttribute(ERROR_MESSAGE) == null ? "Nothing" : request.getAttribute(ERROR_MESSAGE)%></h1>
<form action="${pageContext.request.contextPath}/first_time_login" method="post">
    <% for (int i = 0; i < 3; i++) {%>
        <label>
            <select name="<%=PARAMS_QUESTIONS%>">
                <option>Select Hint Question</option>
                <% for (int j = 0; j < LIST_HINT_QUESTIONS.length; j++) {%>
                    <option value="<%=j%>"><%=LIST_HINT_QUESTIONS[j]%></option>
                <% }%>
            </select>
            <br><input type="text" name="<%=PARAMS_ANSWERS%>"></label><br>
    <% } %>

    <label>Old password:<br><input type="password" name="<%= PARAMS_OLD_PASSWORD%>"></label><br>
    <label>New password:<br><input type="password" name="<%= PARAMS_NEW_PASSWORD%>"></label><br>
    <label>Confirm new password:<br><input type="password" name="<%=PARAMS_CONFIRM_NEW_PASSWORD%>"></label><br>
    <input type="submit">
</form>

<script src="vendors/js/jquery.min.js"></script>
<%@include file="components/footer.jsp" %>

</body>
</html>
