package lms.funix.lab.view;

public class View {
    public static final String[] LIST_HINT_QUESTIONS = {"Bạn là người nước gì?", "Thú nuôi đầu tiên của bạn là gì?", "Lần đầu tiên bạn 5 điểm Hoá là khi nào?"};

    public static final String USER_SESSION_NAME = "user";

    public class Login {
        public static final String MSG1 = "userID and password doesn't match!";

        public class Params {
            public static final String USER_ID = "user_id";
            public static final String PASSWORD = "password";
        }
    }

    public class LoginFirstTime {
        public static final String MSG1 = "new Password and new confirm password must be identical!";
        public static final String MSG2 = "old password doesn't match!";

        public class Params {
            public static final String PARAMS_ANSWERS = "answers";
            public static final String PARAMS_QUESTIONS = "questions";
            public static final String PARAMS_OLD_PASSWORD = "old_password";
            public static final String PARAMS_NEW_PASSWORD = "new_password";
            public static final String PARAMS_CONFIRM_NEW_PASSWORD = "confirm_new_password";

            public static final String ERROR_MESSAGE = "errorMessage";
        }
    }

    public class Path {
        public static final String LOGIN_JSP = "login.jsp";
        public static final String FIRST_TIME_LOGIN_JSP = "first_time_login.jsp";
        public static final String PORTAL_FACILITIES_JSP = "portal_facilities.jsp";

        public class DAO {
            public static final String RESOURCE_LOCATION = "src/main/resources/";
            public static final String FILE_PATH = "users.txt";
            public static final String SEPARATOR = "_";
        }
    }

}
