package lms.funix.lab.bo;

import lms.funix.lab.dao.UserDAO;
import lms.funix.lab.entities.User;

import java.util.Objects;
import java.util.regex.Pattern;

import static lms.funix.lab.view.View.Login.Config.*;
import static lms.funix.lab.view.View.Login.*;


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

    /**
     * @param user
     * @return true if correct, false if user doesn't exist in database
     * @throws Exception - errorMessage if user found but if also wrong password -> also increase failed attempts
     */
    public boolean login(User user) throws Exception {
        return UserDAO.validateUser((User validatingUser) -> { //callback function
            if (Objects.equals(user.getUserID(), validatingUser.getUserID())) {
                // if userID matches
                if (validatingUser.getFailedAttempts() >= MAX_ATTEMPTS) {
                    throw new Exception(MSG3);
                } else if (Objects.equals(user.getPassword(), validatingUser.getPassword())) {
                    return true;
                } else {
                    validatingUser.increaseFailedAttempts();
                    UserDAO.updateUser(validatingUser);
                    throw new Exception(MSG2 + (MAX_ATTEMPTS - validatingUser.getFailedAttempts()));
                }
            }
            return false;
        });
    }
}
