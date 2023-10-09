package com.edu.lab2.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.lab2.bean.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    HttpSession session;

    @Autowired
    ServletContext context;

    @RequestMapping("/student")
    public String hello(ModelMap model, @RequestParam("index") Optional<Integer> index) throws Exception {
        model.addAttribute("message", "Welcome to Thymeleaf");
        ObjectMapper mapper = new ObjectMapper();
        String path = "src\\main\\resources\\static\\students.json";
        var type = new TypeReference<List<Student>>() {
        };
        List<Student> list = mapper.readValue(new File(path), type);

        Student student = list.get(index.orElse(0));

        model.addAttribute("student", student);
        model.addAttribute("index", index.orElse(0));
        return "students";
    }
}
