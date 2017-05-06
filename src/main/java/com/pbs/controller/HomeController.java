package com.pbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Michael on 27/04/2017.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "PBS Home Controller!";
    }
}
