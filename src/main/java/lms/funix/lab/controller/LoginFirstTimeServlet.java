package lms.funix.lab.controller;

import lms.funix.lab.bo.LoginBO;
import lms.funix.lab.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static lms.funix.lab.view.View.LIST_HINT_QUESTIONS;
import static lms.funix.lab.view.View.LoginFirstTime.Params.*;
import static lms.funix.lab.view.View.Path.FIRST_TIME_LOGIN_JSP;
import static lms.funix.lab.view.View.USER_SESSION_NAME;

@WebServlet(name = "LoginFirstTimeServlet")
public class LoginFirstTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Map<String, String[]> parameterMap = request.getParameterMap();

        final String oldPassword = parameterMap.get(PARAMS_OLD_PASSWORD)[0];
        final String newPassword = parameterMap.get(PARAMS_NEW_PASSWORD)[0];
        final String confirmPassword = parameterMap.get(PARAMS_CONFIRM_NEW_PASSWORD)[0];
        final String[] questions = Arrays.stream(parameterMap.get(PARAMS_QUESTIONS)).map(e -> LIST_HINT_QUESTIONS[Integer.parseInt(e)]).toArray(String[]::new);
        final String[] answers = parameterMap.get(PARAMS_ANSWERS);

        final User currentUser = (User) request.getSession().getAttribute(USER_SESSION_NAME);

        if (currentUser == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        final String errorMessage = new LoginBO().checkPassword(currentUser, oldPassword, newPassword, confirmPassword);

        request.setAttribute(ERROR_MESSAGE, errorMessage);
        request.getRequestDispatcher(FIRST_TIME_LOGIN_JSP).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(FIRST_TIME_LOGIN_JSP);
    }
}
