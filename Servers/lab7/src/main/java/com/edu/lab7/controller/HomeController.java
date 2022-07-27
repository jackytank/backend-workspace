package com.edu.lab7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/authorize/index.html")
    public String index() {
        return "authorize/index";
    }
}
