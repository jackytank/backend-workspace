package com.edu.lab2.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.lab2.bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OperatorController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    HttpSession session;

    @Autowired
    ServletContext context;

    @RequestMapping("/operator")
    public String hello(ModelMap model) throws Exception {
        model.addAttribute("x", 5);
        model.addAttribute("y", 7);
        return "operator";
    }

}
