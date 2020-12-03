package lms.funix.lab.view;

public class View {
    public static final String[] LIST_HINT_QUESTIONS = {"Bạn là người nước gì?", "Thú nuôi đầu tiên của bạn là gì?", "Lần đầu tiên bạn 5 điểm Hoá là khi nào?"};

    public static final String USER_SESSION_NAME = "user";

    public static class Login {
        public static final String MSG1 = "userID and password is invalid! Name must have only numbers and not have longer than 16 characters.";
        public static final String MSG2 = "Invalid User ID/Password. Number of attempts left ";
        public static final String MSG3 = "Your ID has been locked due to too many failed attempts, you need to call the Call center to unlock the User ID";

        public static class Config {
            public static final int MAX_ATTEMPTS = 3;
            public static final String USERID_REGEX_MATCHER = "^\\d{1,16}$";
            public static final int PASSWORD_MAX_LENGTH = 8;
        }

        public static class Params {
            public static final String USER_ID = "user_id";
            public static final String PASSWORD = "password";
        }
    }

    public static class LoginFirstTime {
        public static final String MSG1 = "new Password and new confirm password must be identical!";
        public static final String MSG2 = "old password doesn't match!";
        public static final String MSG3 = "The new password must be different from the old password";
        public static final String MSG4 = "You must answer at least one (1) of the hint question below";
        public static final String MSG5 = "Password changed successfully! Please login again";

        public static class Config {
            public static final int NULL_HINT_QUESTION = -1;
        }

        public static class Params {
            public static final String PARAMS_ANSWERS = "answers";
            public static final String PARAMS_QUESTIONS = "questions";
            public static final String PARAMS_OLD_PASSWORD = "old_password";
            public static final String PARAMS_NEW_PASSWORD = "new_password";
            public static final String PARAMS_CONFIRM_NEW_PASSWORD = "confirm_new_password";

            public static final String ERROR_MESSAGE = "errorMessage";
        }
    }

    public static class Path {
        public static final String LOGIN_JSP = "login.jsp";
        public static final String FIRST_TIME_LOGIN_JSP = "first_time_login.jsp";
        public static final String PORTAL_FACILITIES_JSP = "portal_facilities.jsp";
        public static final String FORGOT_PASSWORD_JSP = "forgot_password.jsp";

        public static final String FIRST_TIME_LOGIN_SERVLET = "first_time_login";
        public static final String LOGIN_SERVLET = "/";

        public static class DAO {
            public static class Convention {
                public static final String TRUE_STRING = "1";
                public static final String FALSE_STRING = "0";

                public static class User {
                    public static final int USER_ID_INDEX = 0;
                    public static final int PASSWORD_INDEX = 1;
                    public static final int IS_FIRST_LOGIN_INDEX = 2;
                    public static final int FAIL_COUNT_INDEX = 3;
                }
            }

            public static final String DATABASE_LOCATION = "database\\";
            public static final String SEPARATOR = "_";
            public static String resourcePath;

            public static class FilePath {
                public static final String USER_FILE = "users.txt";
                public static final String HINTS_ANSWER_FILE = "hintsAnswer.txt";
            }

            public static String getResourcePath() {
                return resourcePath;
            }

            public static void setResourcePath(String resourcePath) {
                DAO.resourcePath = resourcePath;
            }
        }
    }

}
