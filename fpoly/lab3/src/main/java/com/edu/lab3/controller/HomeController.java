package com.edu.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home/index")
    public String homeindex() {
        return "home/index";
    }

    @GetMapping("/home/about")
    public String homeabout() {
        return "home/about";
    }
}
