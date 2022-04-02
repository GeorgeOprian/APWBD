package com.awbd.lab2;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class Controller {

    @RequestMapping("/home")
    //@ResponseBody
    public String home(){
        return "Hello World!";
    }

}
