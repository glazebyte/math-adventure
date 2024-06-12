package com.math;

public class User {
    private String username;
    private String passsword;
    private boolean admin;
    public User(String username,boolean admin){
        this.username=username;
        this.admin=admin;
    }

    public String getUsername() {
        return username;
    }

    // Getter untuk admin
    public boolean isAdmin() {
        return admin;
    }
}
