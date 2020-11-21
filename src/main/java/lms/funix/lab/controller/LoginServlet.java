package lms.funix.lab.controller;

import lms.funix.lab.bo.Login;
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
        User user = new User(user_id, password);
        final Login login = new Login();

//        if (login.validate(user)) { //check syntax
//            if (login.login(user)) { //check if exists in database
//                if (user.isFirstLogin()) {
//
//                }
//            }
//        }
//
        response.getWriter().println(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
