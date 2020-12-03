package lms.funix.lab.commons;

import lms.funix.lab.entities.User;

@FunctionalInterface
public interface HelperUserCallback {
    boolean callbackWithUser(User user) throws Exception;
}
