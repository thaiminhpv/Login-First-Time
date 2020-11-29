package lms.funix.lab.controller;

import lms.funix.lab.bo.LoginBO;
import lms.funix.lab.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static lms.funix.lab.view.View.Login.MSG1;
import static lms.funix.lab.view.View.Login.MSG2;
import static lms.funix.lab.view.View.Login.Params.PASSWORD;
import static lms.funix.lab.view.View.Login.Params.USER_ID;
import static lms.funix.lab.view.View.LoginFirstTime.Params.ERROR_MESSAGE;
import static lms.funix.lab.view.View.Path.*;
import static lms.funix.lab.view.View.USER_SESSION_NAME;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String user_id = request.getParameter(USER_ID);
        final String password = request.getParameter(PASSWORD);
        final User user = new User(user_id, password);

        final LoginBO loginBO = new LoginBO();
        //TODO: count number of failure attempts and lock account
        //TODO: split case correct UserID and Wrong Password to invalid syntax

        if (loginBO.validate(user)) { //check syntax
            if (loginBO.login(user)) { //check if exists in database
                if (user.isFirstLogin()) {
                    request.getSession().setAttribute(USER_SESSION_NAME, user);
                    response.sendRedirect(FIRST_TIME_LOGIN_SERVLET);
                } else {
                    request.getSession().setAttribute(USER_SESSION_NAME, user);
                    response.sendRedirect(PORTAL_FACILITIES_JSP);
                }
            } else {
                request.setAttribute(ERROR_MESSAGE, MSG2);
                //TODO: increase count
                request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
            }
        } else {
            request.setAttribute(ERROR_MESSAGE, MSG1);
            request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(LOGIN_JSP);
    }
}
