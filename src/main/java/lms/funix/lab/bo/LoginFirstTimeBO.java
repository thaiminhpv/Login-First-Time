package lms.funix.lab.bo;

import lms.funix.lab.dao.HintDAO;
import lms.funix.lab.entities.User;

import java.util.Map;
import java.util.Objects;

import static lms.funix.lab.view.View.LoginFirstTime.*;

public class LoginFirstTimeBO {
    /**
     * add Hints to database with user's userID
     * @param user
     * @param hints
     * @throws Exception - error message
     */
    public void addHints(User user, Map<String, String> hints) throws Exception {
        if (hints.isEmpty()) throw new Exception(MSG3);
        HintDAO.addHints(user.getUserID(), hints);
    }

    /**
     * @param user
     * @param oldPassword
     * @param newPassword
     * @param confirmPassword
     * @throws Exception - error message
     */
    public void checkChangePassword(User user, String oldPassword, String newPassword, String confirmPassword) throws Exception {
        if (!Objects.equals(newPassword, confirmPassword)) {
            throw new Exception(MSG1);
        } else if (!Objects.equals(user.getPassword(), oldPassword)) {
            throw new Exception(MSG2);
        }
    }

    public void changePassword(User user, String newPassword) {
    }
}
