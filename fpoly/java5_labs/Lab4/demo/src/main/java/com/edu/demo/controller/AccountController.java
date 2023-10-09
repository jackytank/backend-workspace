package com.edu.demo.controller;

import com.edu.demo.service.CookieService;
import com.edu.demo.service.ParamService;
import com.edu.demo.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    SessionService sessionService;

    @Autowired
    ParamService paramService;

    @Autowired
    CookieService cookieService;

    @GetMapping("/login")
    public String getLogin() {
        return "redirect:/products";
    }

    @PostMapping("/login")
    public ModelAndView postLogin(ModelMap model) {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);
        if (username.equals("poly") && password.equals("1221")) {
            sessionService.set("username", username);
            model.addAttribute("message", "Login Successfully!!!!!!");
        }
        if (remember) {
            cookieService.add("username", username, 1);
            cookieService.add("password", password, 1);
            cookieService.add("remember", remember + "", 1);
        } else {
            cookieService.remove("username");
            cookieService.remove("password");
            cookieService.remove("remember");
        }
        return new ModelAndView("redirect:/products", model);
    }

    @GetMapping("/logout")
    public String getLogOut() {
        sessionService.remove("username");
        return "redirect:/products";
    }
}
