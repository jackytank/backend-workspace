package com.edu.demo.controller;

import com.edu.demo.service.CookieService;
import com.edu.demo.service.ParamService;
import com.edu.demo.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String postLogin() {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        sessionService.set("username", username);

        if (remember) {
            cookieService.add("username", username, 1);
            cookieService.add("password", password, 1);
            cookieService.add("remember", remember + "", 1);
        } else {
            cookieService.remove("username");
            cookieService.remove("password");
            cookieService.remove("remember");
        }
        return "redirect:/products";
    }

    @GetMapping("/logout")
    public String getLogOut() {
        sessionService.remove("username");
        return "redirect:/products";
    }
}
