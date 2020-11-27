package lms.funix.lab.controller;

import lms.funix.lab.bo.LoginBO;
import lms.funix.lab.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String user_id = request.getParameter("user_id");
        final String password = request.getParameter("password");
        final User user = new User(user_id, password);

        final LoginBO loginBO = new LoginBO();

        if (loginBO.validate(user)) { //check syntax
            if (loginBO.login(user)) { //check if exists in database
                if (user.isFirstLogin()) {
                }
            }
        }

        response.getWriter().println(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
