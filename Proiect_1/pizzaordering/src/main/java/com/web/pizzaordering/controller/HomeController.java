package com.web.pizzaordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/login")
    public String logInPage() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logOutPage() {
        return "logout";
    }



}
