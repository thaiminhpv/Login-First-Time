package lms.funix.lab.entities;

public class User {
    private String userID;
    private String password;
    private boolean firstLogin = true;
    private String [] hintAnswers;

    public User(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public User(String userID, String password, String[] hintAnswers) {
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

    public String[] getHintAnswers() {
        return hintAnswers;
    }

    public void setHintAnswers(String[] hintAnswers) {
        this.hintAnswers = hintAnswers;
    }
}
