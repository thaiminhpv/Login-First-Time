package lms.funix.lab.entities;

import java.util.Map;
import java.util.Objects;

public class User {
    private String userID;
    private String password;
    private boolean firstLogin = true;
    private Map<String, String> hintAnswers;

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public User(String userID, String password, Map<String, String> hintAnswers) {
        this.userID = userID;
        this.password = password;
        this.hintAnswers = hintAnswers;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", firstLogin=" + firstLogin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID.equals(user.userID) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, password);
    }

    public Map<String, String> getHintAnswers() {
        return hintAnswers;
    }

    public void setHintAnswers(Map<String, String> hintAnswers) {
        this.hintAnswers = hintAnswers;
    }

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
