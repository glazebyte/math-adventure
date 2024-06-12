package com.math;

public class UserHolder {
    private static UserHolder instance;
    private User loggedInUser;

    private UserHolder() {
        // private constructor to prevent instantiation
    }

    public static synchronized UserHolder getInstance() {
        if (instance == null) {
            instance = new UserHolder();
        }
        return instance;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public void clearLoggedInUser() {
        this.loggedInUser = null;
    }
}