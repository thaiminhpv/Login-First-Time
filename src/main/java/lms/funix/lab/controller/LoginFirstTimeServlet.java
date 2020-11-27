package lms.funix.lab.controller;

import lms.funix.lab.bo.LoginBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "LoginFirstTimeServlet")
public class LoginFirstTimeServlet extends HttpServlet {
    public static final String[] LIST_HINT_QUESTIONS = {"Bạn là người nước gì?", "Thú nuôi đầu tiên của bạn là gì?", "Lần đầu tiên bạn 5 điểm Hoá là khi nào?"};

    public static final String PARAMS_ANSWERS = "answers";
    public static final String PARAMS_QUESTIONS = "questions";
    public static final String PARAMS_OLD_PASSWORD = "old_password";
    public static final String PARAMS_NEW_PASSWORD = "new_password";
    public static final String PARAMS_CONFIRM_NEW_PASSWORD = "confirm_new_password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Map<String, String[]> parameterMap = request.getParameterMap();

        final String oldPassword = parameterMap.get(PARAMS_OLD_PASSWORD)[0];
        final String newPassword = parameterMap.get(PARAMS_NEW_PASSWORD)[0];
        final String confirmPassword = parameterMap.get(PARAMS_CONFIRM_NEW_PASSWORD)[0];
        final String[] questions = Arrays.stream(parameterMap.get(PARAMS_QUESTIONS)).map(e -> LIST_HINT_QUESTIONS[Integer.parseInt(e)]).toArray(String[]::new);
        final String[] answers = parameterMap.get(PARAMS_ANSWERS);

//        new LoginBO().checkPassword(oldPassword, newPassword, confirmPassword);

//        request.setAttribute("errorMessage", errorMessage);
//        request.getRequestDispatcher("first_time_login.jsp").forward(request, response);

        response.getWriter().println("Done!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("first_time_login.jsp");
    }
}
