package com.pbs.model;

/**
 * Created by Michael on 10/05/2017.
 * An object to hold the basic details of a userName
 */
public class User {
    String userName;
    String password;
    String permissions;

    public User(String userName, String password, String permissions) {
        this.userName = userName;
        this.password = password;
        this.permissions = permissions;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
