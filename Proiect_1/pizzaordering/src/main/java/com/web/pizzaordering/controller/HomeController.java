package com.web.pizzaordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"", "/","/index"})
    public String home() {
        return "index";
    }

    @GetMapping("/loginForm")
    public String logInPage() {
        return "login";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }

}
