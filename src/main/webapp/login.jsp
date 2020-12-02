<%@ page import="static lms.funix.lab.view.View.Login.Params.PASSWORD" %>
<%@ page import="static lms.funix.lab.view.View.Login.Params.USER_ID" %>
<%@ page import="static lms.funix.lab.view.View.LoginFirstTime.Params.ERROR_MESSAGE" %>
<%@ page import="static lms.funix.lab.view.View.Path.FORGOT_PASSWORD_JSP" %>
<%@ page import="lms.funix.lab.view.View" %>
<%@ page import="static lms.funix.lab.view.View.Path.FORGOT_PASSWORD_JSP" %><%--
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
    <%@include file="components/lib.html"%>
    <link rel="stylesheet" href="assets/style/login.css">
</head>
<body class="container-fluid">
<%@include file="components/header.html" %>

<main>
    <h1 class="m-4">Login to MyGSeT Portal</h1>
    <hr>
    <div class="w-100 row">
        <div class="col-lg-8 col-11 mx-auto my-2">
            <div class="border p-1">
                <div class="row img-container"><img class="col-12" src="assets/images/alison_courseware_intro_1492.jpg"
                                                    alt="banner"></div>
                <div class="row">
                    <div class="col-6 text-center m-auto">
                        <p>Enter your Single Sign-On User ID and password to login</p>
                        <p class="text-danger"><%=request.getAttribute(ERROR_MESSAGE) == null ? "Authentication failed. Please try again" : request.getAttribute(ERROR_MESSAGE)%></p>
                        <p>If you have forgotten your password.
                            <a href="<%=FORGOT_PASSWORD_JSP%>">Click here.</a>
                        </p>

                    </div>
                    <div class="col-6 justify-content-center bg-light">
                        <h2 class="m-2 text-info">MEMBER LOGIN</h2>
                        <form action="${pageContext.request.contextPath}/" method="post">
                            <div class="w-100">
                                <div class="row">
                                    <p class="col-3 font-weight-bold text-right"><label for="<%=USER_ID%>">User ID</label></p>
                                    <div class="col-9 pr-5">
                                        <input class="w-100" type="text" name="<%=USER_ID%>" value="" id="<%=USER_ID%>">
                                        <p class="text-danger mb-0">(max 16 characters)</p>
                                    </div>
                                </div>
                            </div>
                            <div class="w-100">
                                <div class="row">
                                    <p class="col-3 font-weight-bold text-right"><label for="<%=PASSWORD%>">Password</label></p>
                                    <div class="col-9 pr-5">
                                        <input class="w-100" type="password" name="<%=PASSWORD%>" value="" id="<%=PASSWORD%>">
                                        <p class="text-danger">(max 8 characters)</p>
                                    </div>
                                </div>
                            </div>
                            <div class="w-100 row">
                                <div class="col-4"></div>
                                <div>
                                    <input class="mr-3 bg-primary text-warning" type="submit">
                                    <input class="bg-primary text-warning" type="button" value="Clear" onClick="clearInput()">
                                    <div><a href="<%=FORGOT_PASSWORD_JSP%>">Forgot Password</a></div> <!-- TODO -->
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <p class="note text-center">Unauthorized use of this site is prohibited and may subject you to civil and criminal prosecution</p>
        </div>
    </div>
</main>

<%@include file="components/footer.html" %>
<%@include file="components/script_lib.html"%>
<script>
    function clearInput() {
        $('#username,#password').val('');
    }
</script>
</body>
</html>
