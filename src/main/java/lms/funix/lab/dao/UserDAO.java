package lms.funix.lab.dao;

import lms.funix.lab.entities.User;

public class UserDAO {
    public static synchronized void addUser(User user) {

    }

    /**
     * @param user return updated hints to user
     */
    public static boolean validate(User user) {
        //TODO read Users from file and check if exists and then update hints
        return false;
    }
}
