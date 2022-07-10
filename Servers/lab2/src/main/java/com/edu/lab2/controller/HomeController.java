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
public class HomeController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    HttpSession session;

    @Autowired
    ServletContext context;

    @RequestMapping("/home/index")
    public String hello(ModelMap model) throws Exception {
        model.addAttribute("message", "Welcome to Thymeleaf");
        ObjectMapper mapper = new ObjectMapper();
        String path = "src\\main\\resources\\static\\student.json";
        Student student = mapper.readValue(new File(path), Student.class);
        model.addAttribute("student", student);
        return "home/index";
    }

    @RequestMapping("/scope")
    public String scope(ModelMap model) throws Exception {
        model.addAttribute("a", "I'm in model");
        req.setAttribute("b", "I'm in request");
        session.setAttribute("c", "I'm in session");
        context.setAttribute("d", "I'm in servletContext");
        return "scope";
    }
}
