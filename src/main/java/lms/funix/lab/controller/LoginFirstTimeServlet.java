package lms.funix.lab.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginFirstTimeServlet")
public class LoginFirstTimeServlet extends HttpServlet {
    public static final String[] PARAMS_HINT_ANSWERS = {"hint1", "hint2", "hint3"};
    public static final String[] PARAMS_HINT_QUESTIONS = {"Bạn là người nước gì?", "Thú nuôi đầu tiên của bạn là gì?", "Lần đầu tiên bạn 5 điểm Hoá là khi nào?"};

    public static final String PARAMS_OLD_PASSWORD = "old_password";
    public static final String PARAMS_NEW_PASSWORD = "new_password";
    public static final String PARAMS_CONFIRM_NEW_PASSWORD = "confirm_new_password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        final String hint1 = request.getParameter(PARAMS_HINT_ANSWERS[0]);
//        final String hint2 = request.getParameter(PARAMS_HINT_ANSWERS[1]);
//        final String hint3 = request.getParameter(PARAMS_HINT_ANSWERS[2]);
//        final String oldPassword = request.getParameter(PARAMS_OLD_PASSWORD);
//        final String newPassword = request.getParameter(PARAMS_OLD_PASSWORD);
//        final String confirmNewPassword = request.getParameter(PARAMS_CONFIRM_NEW_PASSWORD);

//        response.getWriter().println("login first time servlet request received");
        response.getWriter().println(request.getParameter("answers"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/first_time_login.jsp").forward(request, response);
    }
}
