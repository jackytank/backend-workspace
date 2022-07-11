package com.edu.lab2.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
public class Student2Controller {
    @Autowired
    HttpServletRequest req;

    @Autowired
    HttpSession session;

    @Autowired
    ServletContext context;

    @RequestMapping("/student/list")
    public String list(ModelMap model, @RequestParam("index") Optional<Integer> index) throws Exception {
        File file = new ClassPathResource("/static/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        var type = new TypeReference<List<Student>>() {

        };
        List<Student> list = mapper.readValue(file, type);

        model.addAttribute("student", list.get(index.orElse(0)));
        model.addAttribute("studentList", list);
        return "student/list";
    }
}
