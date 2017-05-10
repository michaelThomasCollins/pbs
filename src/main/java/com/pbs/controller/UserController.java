package com.pbs.controller;

import com.pbs.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Michael on 10/05/2017.
 * A controller concerned with the passing of User Data,
 * used primarily as a getter, will need to implement login features in next prototype
 */
@RestController
@RequestMapping("api/v1/")
public class UserController {

    @RequestMapping(value = "users/{userName}", method = RequestMethod.GET)
    public User get(@PathVariable String userName) {
        return UserStub.get(userName);
    }
}
