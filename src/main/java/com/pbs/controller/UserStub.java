package com.pbs.controller;

import com.pbs.model.Report;
import com.pbs.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michael on 10/05/2017.
 * A stub to pass in "Mocked" Users and their values
 * For Non-Prototype, will have to look into a console for creating/deleting users
 */
public class UserStub {
    private static Map<String, User> users = new HashMap<String, User>();
    private static Integer idIndex = 3;

    //populate initial users
    static {
        String uname1="Michael_Collins";
        String uname2="Frank_Duffy";
        String uname3="Mr_Man";
        User a = new User(uname1, "Password1", "Officer");
        users.put(uname1, a);
        User b = new User(uname2, "Arse1", "Verifier");
        users.put(uname2, b);
        User c = new User(uname3, "Ihatespring1", "Officer");
        users.put(uname3, c);
    }

    //Return  a list of all users in the system
    public static List<User> list() {
        return new ArrayList<User>(users.values());
    }

    //Return a user
    public static User get(String userName) {
        return users.get(userName);
    }

}
