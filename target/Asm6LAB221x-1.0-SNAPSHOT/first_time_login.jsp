<%@ page import="static lms.funix.lab.view.View.LIST_HINT_QUESTIONS" %>
<%@ page import="static lms.funix.lab.view.View.LoginFirstTime.Params.*" %>
<%@ page import="static lms.funix.lab.view.View.LoginFirstTime.Config.NULL_HINT_QUESTION" %>
<%@ page import="lms.funix.lab.view.View" %><%--
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
    <%@include file="components/lib.html" %>
</head>
<body class="container-fluid">

<%@include file="components/header.html" %>


<main>
    <h1 class="m-4">First Time Login</h1>
    <hr>
    <div class="w-100 row my-5">
        <div class="col-lg-9 col-11 mx-auto my-2 row">
            <div class="col-4 overflow-hidden"><img src="assets/images/alison_courseware_intro_1492.jpg" alt=""></div>
            <form action="${pageContext.request.contextPath}/<%=View.Path.FIRST_TIME_LOGIN_SERVLET%>" method="post"
                  class="col-8">
                <div class="">
                    <p>Please answer at least one (1) of the hint question below. Maximum selection is three (3)
                        questions</p>
                    <% for (int i = 0; i < 3; i++) {%>
                    <label class="w-100 ml-3 row">
                        <select class="col-5" name="<%=PARAMS_QUESTIONS%>">
                            <option value="<%=NULL_HINT_QUESTION%>">- Select Hint Question -</option>
                            <% for (int j = 0; j < LIST_HINT_QUESTIONS.length; j++) {%>
                            <option value="<%=j%>"><%=LIST_HINT_QUESTIONS[j]%>
                            </option>
                            <% }%>
                        </select>
                        <input class="col-7" type="text" name="<%=PARAMS_ANSWERS%>"></label>
                    <%}%>
                </div>
                <div class="text-right">
                    <p class="text-left text-danger">
                        <%=request.getAttribute(ERROR_MESSAGE) == null ?
                                "Please key in your old password and new password. The new password must be different from the old password"
                                : request.getAttribute(ERROR_MESSAGE)%>
                    </p>
                    <label class="row w-100 ml-3">
                        <p class="col-5">Old password:</p><input class="col-7" type="password"
                                                                 name="<%= PARAMS_OLD_PASSWORD%>">
                    </label>
                    <label class="row w-100 ml-3">
                        <p class="col-5">New password:</p><input class="col-7" type="password"
                                                                 name="<%= PARAMS_NEW_PASSWORD%>">
                    </label>
                    <label class="row w-100 ml-3">
                        <p class="col-5">Confirm new password:</p><input class="col-7" type="password"
                                                                         name="<%=PARAMS_CONFIRM_NEW_PASSWORD%>">
                    </label>
                </div>

                <div class="w-100 row">
                    <div class="offset-3">
                        <input class="mr-3 bg-primary text-warning" type="submit" value="Submit">
                        <input class="mr-3 bg-primary text-warning" type="button" value="Cancel" onClick="cancel()">
                        <input class="bg-primary text-warning" type="button" value="Clear" onClick="clearInput()">
                    </div>
                </div>

            </form>
        </div>
    </div>
    <hr>
</main>

<%@include file="components/footer.html" %>
<%@include file="components/script_lib.html" %>
<script>
    function clearInput() {
        $('label > input').val('');
    }
    function cancel() {
        window.location.href = "./";
    }
</script>

</body>
</html>
