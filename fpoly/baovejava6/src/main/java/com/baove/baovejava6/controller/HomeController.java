package com.baove.baovejava6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping({ "admin", "/" })
    public String admin() {
        return "admin/index";
    }
}
