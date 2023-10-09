package com.edu.lab3.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.lab3.model.Student;

@Controller
public class StudentController {

    @RequestMapping("/student/form")
    public String form(ModelMap model) {
        Student student = new Student();
        student.setEmail("supersoi@gmail.com");
        student.setFullname("Spyderman");
        student.setGender(true);
        student.setMarks(4.6);
        student.setCountry("VN");
        model.addAttribute("student", student);
        return "student/form";
    }

    @PostMapping("/student/save")
    public String save(@ModelAttribute("student") Student form) {
        return "student/success";
    }

    @ModelAttribute("countries")
    public Map<String, String> getCountries() {
        Map<String, String> map = new HashMap<>();
        map.put("VM", "Việt Nam");
        map.put("US", "Mẽo");
        map.put("DL", "Đông Lào");
        return map;
    }
}
