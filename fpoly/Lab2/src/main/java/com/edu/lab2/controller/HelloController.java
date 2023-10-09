package com.edu.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello.th")
    public String hello(ModelMap model) {
        model.addAttribute("message", "FPT <b> Polytechnic </b>");
        return "hello";
    }
}
