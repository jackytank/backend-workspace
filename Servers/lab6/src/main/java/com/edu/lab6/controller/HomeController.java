package com.edu.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

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
        if (!request.isUserInRole("ADMIN")) {
            return "redirect:/auth/access/denied";
        }
        model.addAttribute("message", "Hello Administrator!");
        return "home/index";
    }

    //    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping("/home/users")
    public String users(ModelMap model) {
        if (!(request.isUserInRole("ADMIN") || request.isUserInRole("USER"))) {
            return "redirect:/auth/access/denied";
        }
        model.addAttribute("message", "Hello staff");
        return "home/index";
    }

    //    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/home/authenticated")
    public String authenticated(ModelMap model) {
        if (request.getRemoteUser() == null) {
            return "redirect:/auth/login/form";
        }
        model.addAttribute("message", "Hello authenticated users!");
        return "home/index";
    }

    @RequestMapping("/auth/access/denied")
    public String accessDenied(ModelMap model) {
        model.addAttribute("message", "You are not authorized to access!");
        return "auth/login";
    }

    @RequestMapping("/home/thymeleaf1")
    public String thymeleaf1(ModelMap model) {
        model.addAttribute("message", "Thymeleaf - Without Extras");
        return "home/thymeleaf1";
    }

    @RequestMapping("/home/thymeleaf2")
    public String thymeleaf2(ModelMap model) {
        model.addAttribute("message", "Thymeleaf - With Extras");
        return "home/thymeleaf2";
    }
}
