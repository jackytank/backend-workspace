package com.edu.lab7.controller;

import com.edu.lab7.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @GetMapping("/authorize/index.html")
    public String index() {
        return "authorize/index";
    }

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/home/index")
    public String index(ModelMap model) {
        model.addAttribute("message", "This is homepage");
        return "home/index";
    }

    @RequestMapping("/home/about")
    public String about(ModelMap model) {
        model.addAttribute("message", "This is about page");
        return "home/index";
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/home/admins")
    public String admins(ModelMap model) {
        model.addAttribute("message", "Hello Administrator!");
        return "home/index";
    }

    //    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping("/home/users")
    public String users(ModelMap model) {
        model.addAttribute("message", "Hello staff");
        return "home/index";
    }

    //    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/home/authenticated")
    public String authenticated(ModelMap model) {
        model.addAttribute("message", "Hello authenticated users!");
        return "home/index";
    }

    @RequestMapping("/auth/access/denied")
    public String accessDenied(ModelMap model) {
        model.addAttribute("message", "You are not authorized to access!");
        return "auth/login";
    }
}
