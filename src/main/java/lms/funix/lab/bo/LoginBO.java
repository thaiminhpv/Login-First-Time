package lms.funix.lab.bo;

import lms.funix.lab.dao.UserDAO;
import lms.funix.lab.entities.User;

import java.util.regex.Pattern;

import static lms.funix.lab.view.View.Login.Config.PASSWORD_MAX_LENGTH;
import static lms.funix.lab.view.View.Login.Config.USERID_REGEX_MATCHER;
import static lms.funix.lab.view.View.Login.MSG1;


public class LoginBO {
    /**
     * @param user
     * @return nothing
     * @throws Exception (ErrorMessage)
     */
    public void validate(User user) throws Exception {
        if (!Pattern.matches(USERID_REGEX_MATCHER, user.getUserID())
                || user.getPassword().isEmpty()
                || user.getPassword().length() > PASSWORD_MAX_LENGTH) {
            throw new Exception(MSG1);
        }
    }

    public boolean login(User user) throws Exception {
        return UserDAO.validateUser(user);
    }
}
