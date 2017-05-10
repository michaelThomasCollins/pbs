package com.pbs.model;

/**
 * Created by Michael on 10/05/2017.
 * An object to hold the basic details of a user
 */
public class User {
    String user;
    String password;
    String permissions;

    public User(String user, String password, String permissions) {
        this.user = user;
        this.password = password;
        this.permissions = permissions;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
