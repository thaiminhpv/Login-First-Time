package lms.funix.lab.bo;

import lms.funix.lab.dao.UserDAO;
import lms.funix.lab.entities.User;
import lms.funix.lab.view.View;

import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

import static lms.funix.lab.view.View.LoginFirstTime.MSG1;
import static lms.funix.lab.view.View.LoginFirstTime.MSG2;


public class LoginBO {
    private static final String USERID_REGEX_MATCHER = "^\\d{1,16}$";
    private static final int PASSWORD_MAX_LENGTH = 8;

    /**
     * Check syntax only
     *
     * @param user
     * @return True if passed
     */
    public boolean validate(User user) {
        return Pattern.matches(USERID_REGEX_MATCHER, user.getUserID())
                && !user.getPassword().isEmpty() && user.getPassword().length() <= PASSWORD_MAX_LENGTH;
    }

    /**
     * @param user
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @return error message
     */
    public String checkPassword(User user, String oldPassword, String newPassword, String confirmPassword) {
        if (!Objects.equals(newPassword, confirmPassword)) {
            return MSG1;
        } else if (!Objects.equals(user.getPassword(), oldPassword)) {
            return MSG2;
        } else {
            return null;
        }
    }

    public void addHints(Map<String, String> hints) {

    }

    public boolean login(User user) {
        return UserDAO.validate(user);
    }
}
