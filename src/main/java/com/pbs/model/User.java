package com.pbs.model;

/**
 * Created by Michael on 10/05/2017.
 * An object to hold the basic details of a user
 */
public class User {
    private String userName;
    private String password;
    private String permissions;
    private String birthday;
    private String street;
    private String houseNo;
    private String postCode;
    private String town;
    private int number;

    public User(String userName, String password, String permissions, String birthday, String street, String houseNo, String postCode, String town, int number) {
        this.userName = userName;
        this.password = password;
        this.permissions = permissions;
        this.birthday = birthday;
        this.street = street;
        this.houseNo = houseNo;
        this.postCode = postCode;
        this.town = town;
        this.number = number;
    }

    /**
     * This method will be used to create "stub" users, as there is no point
     * in incorporating personal details just yet
     *
     * @param userName
     * @param password
     * @param permissions
     */
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
