package lms.funix.lab.bo;

import lms.funix.lab.dao.UserDAO;
import lms.funix.lab.entities.User;

import java.util.Map;
import java.util.regex.Pattern;

public class LoginBO {
    private static final String USERID_REGEX_MATCHER = "^\\d{1,16}$";
    private static final int PASSWORD_MAX_LENGTH = 8;

    /**
     * Check syntax only
     * @param user
     * @return True if passed
     */
    public boolean validate(User user) {
        return Pattern.matches(USERID_REGEX_MATCHER, user.getUserID())
                && !user.getPassword().isEmpty() && user.getPassword().length() <= PASSWORD_MAX_LENGTH;
    }

    public String checkPassword(String oldPassword, String newPassword, String confirmPassword) {

    }

    public void addHints(Map<String, String> hints) {

    }

    public boolean login(User user) {
        return UserDAO.validate(user);
    }
}
