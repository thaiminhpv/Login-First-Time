package lms.funix.lab.bo;

import lms.funix.lab.dao.UserDAO;
import lms.funix.lab.entities.User;

import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

import static lms.funix.lab.view.View.Login.Config.PASSWORD_MAX_LENGTH;
import static lms.funix.lab.view.View.Login.Config.USERID_REGEX_MATCHER;
import static lms.funix.lab.view.View.Login.MSG1;
import static lms.funix.lab.view.View.Login.MSG2;


public class LoginBO {
    /**
     * @param user
     * @return nothing
     * @throws Exception (ErrorMessage)
     */
    public void validate(User user) throws Exception {
        if (!Pattern.matches(USERID_REGEX_MATCHER, user.getUserID())
                || user.getPassword().isEmpty()
                || user.getPassword().length() > PASSWORD_MAX_LENGTH)
            throw new Exception(MSG1);
    }

    /**
     * @param user
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @return error message
     */
    public String checkChangePassword(User user, String oldPassword, String newPassword, String confirmPassword) {
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

    public boolean login(User user) throws Exception {
        return UserDAO.validateUser(user);
    }
}
