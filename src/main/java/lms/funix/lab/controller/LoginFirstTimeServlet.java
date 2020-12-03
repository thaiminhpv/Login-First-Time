package lms.funix.lab.controller;

import lms.funix.lab.bo.LoginFirstTimeBO;
import lms.funix.lab.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static lms.funix.lab.view.View.LIST_HINT_QUESTIONS;
import static lms.funix.lab.view.View.LoginFirstTime.Config.NULL_HINT_QUESTION;
import static lms.funix.lab.view.View.LoginFirstTime.MSG5;
import static lms.funix.lab.view.View.LoginFirstTime.Params.*;
import static lms.funix.lab.view.View.Path.FIRST_TIME_LOGIN_JSP;
import static lms.funix.lab.view.View.Path.LOGIN_JSP;
import static lms.funix.lab.view.View.USER_SESSION_NAME;

@WebServlet(name = "LoginFirstTimeServlet")
public class LoginFirstTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.name());

        // if user not logged in, then redirect them to login page
        final User currentUser = (User) request.getSession().getAttribute(USER_SESSION_NAME);
        if (currentUser == null) {
            response.sendRedirect(LOGIN_JSP);
            return;
        }

        // get parameters from user
        final Map<String, String[]> parameterMap = request.getParameterMap();

        final String oldPassword = parameterMap.get(PARAMS_OLD_PASSWORD)[0];
        final String newPassword = parameterMap.get(PARAMS_NEW_PASSWORD)[0];
        final String confirmPassword = parameterMap.get(PARAMS_CONFIRM_NEW_PASSWORD)[0];
        final String[] questions = Arrays.stream(parameterMap.get(PARAMS_QUESTIONS))
                .filter(s -> !s.equals(String.valueOf(NULL_HINT_QUESTION)))
                .map(e -> LIST_HINT_QUESTIONS[Integer.parseInt(e)])
                .toArray(String[]::new);
        final String[] answers = Arrays.stream(parameterMap.get(PARAMS_ANSWERS))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        final LoginFirstTimeBO bo = new LoginFirstTimeBO();
        try {
            final HashMap<String, String> hintsMap = new HashMap<>();
            for (int i = 0; i < answers.length; i++) {
                hintsMap.put(questions[i], answers[i]);
            }
            bo.addHints(currentUser, hintsMap);
            bo.checkChangePassword(currentUser, oldPassword, newPassword, confirmPassword);
            bo.changePassword(currentUser, newPassword);
            //successfully change password -> navigate user back to login screen
            request.setAttribute(ERROR_MESSAGE, MSG5);
            request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
        } catch (Exception e) {
            request.setAttribute(ERROR_MESSAGE, e.getMessage());
            request.getRequestDispatcher(FIRST_TIME_LOGIN_JSP).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(FIRST_TIME_LOGIN_JSP).forward(request, response);
    }
}
