package com.edu.lab6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    @RequestMapping("/auth/login/form")
    public String form() {
        return "auth/login";
    }

    @RequestMapping("/auth/login/success")
    public String success(ModelMap model) {
        model.addAttribute("message", "Đăng nhập thành công!");
        return "forward:/auth/login/form";
    }

    @RequestMapping("/auth/login/error")
    public String error(ModelMap model) {
        model.addAttribute("message", "Sai thông tin đăng nhập!");
        return "forward:/auth/login/form";
    }

    @RequestMapping("/auth/logoff/success")
    public String logoff(ModelMap model) {
        model.addAttribute("message", "Đăng xuất thành công!");
        return "forward:/auth/login/form";
    }
}
