package lms.funix.lab.entities;

import java.util.Objects;

public class User {
    private String userID;
    private String password;
    private boolean firstLogin = true;
    private int failedAttempts = 0;

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public User(String userID, String password, boolean firstLogin, int failedAttempts) {
        this.userID = userID;
        this.password = password;
        this.firstLogin = firstLogin;
        this.failedAttempts = failedAttempts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", firstLogin=" + firstLogin +
                ", failedAttempts=" + failedAttempts +
                '}';
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public void increaseFailedAttempts() {
        this.failedAttempts++;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, password);
    }

    /**
     * this is just getter, not use this to check user's first login status, use @{isFirstLogin} in {@link lms.funix.lab.dao.UserDAO} instead
     * @return
     */
    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
