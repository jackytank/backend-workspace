package com.edu.lab7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edu.lab7.dao.AccountDAO;
import com.edu.lab7.entity.Account;
import com.edu.lab7.service.CookieService;
import com.edu.lab7.service.SessionService;

@Controller
public class AccountController {
    @Autowired
    AccountDAO dao;

    @Autowired
    SessionService session;

    @Autowired
    CookieService cookie;

    @GetMapping("/account/login")
    public String getLogin() {
        return "account/login";
    }

    @GetMapping("/admin/index")
    public String adminInex() {
        return "admin/index";
    }

    @GetMapping("/admin/loginIndex")
    public String loginIndex() {
        return "admin/loginIndex";
    }

    @PostMapping("/account/login")
    public String postLogin(ModelMap model,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam(value = "remember", required = false) String remember) {

        try {
            Account user = dao.findById(username).get();
            if (user != null && user.getPassword().equals(password)) {
                session.set("user", user);
                String uri = (String) session.get("security-uri");
                if (uri != null) {
                    return "redirect:" + uri;
                } else {
                    if (remember != null) {
                        cookie.add("username", user.getId(), 24);
                        cookie.add("password", user.getPassword(), 24);
                    } else {
                        cookie.remove("username");
                        cookie.remove("password");
                    }
                    model.addAttribute("isLogin", true);
                    model.addAttribute("message", "Login success!");
                    // if (user.getAdmin()) {
                    // return null;
                    // } else {
                    // return new ModelAndView("redirect:/", model);
                    // }
                }

            } else {
                model.addAttribute("message", "Invalid password");
            }
        } catch (Exception e) {
            model.addAttribute("message", "Invalid username");
        }
        return "account/login";
    }
}
