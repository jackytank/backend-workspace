package com.edu.lab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.lab4.dao.Bai3StudentDAO;
import com.edu.lab4.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Bai3Controller {

    @Autowired
    Bai3StudentDAO dao;

    Student student;

    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("student", new Student());
        model.addAttribute("studentList", dao.findAll());
        // dao.findAll().entrySet().stream()
        // .forEach(item -> System.out.println("Key: " + item.getKey() + ",Value: " +
        // item.getValue()));
        return "bai4-java-net-url/index";
    }

    @PostMapping("/create")
    public String create(ModelMap model, @ModelAttribute Student student) {
        dao.create(student);
        model.addAttribute("student", new Student());
        model.addAttribute("studentList", dao.findAll());
        model.addAttribute("message", "Created success!");
        return "bai4-java-net-url/index";
    }

    @PostMapping("/update/{id}")
    public String update(ModelMap model, @ModelAttribute Student student, @PathVariable String id) {
        dao.update(id, student);
        model.addAttribute("student", new Student());
        model.addAttribute("studentList", dao.findAll());
        model.addAttribute("message", "Update success!");
        return "bai4-java-net-url/index";
    }

    @PostMapping("/delete/{id}")
    public String delete(ModelMap model, @PathVariable String id) {
        dao.delete(id);
        model.addAttribute("student", new Student());
        model.addAttribute("studentList", dao.findAll());
        model.addAttribute("message", "Delete success!");
        return "bai4-java-net-url/index";
    }

    @PostMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable String id) {
        student = dao.findByKey(id);
        model.addAttribute("student", student);
        model.addAttribute("studentList", dao.findAll());
        model.addAttribute("message", "Editing student " + student.getFullname() + "!");
        model.addAttribute("key", id);
        return "bai4-java-net-url/index";
    }

    @PostMapping("/reset")
    public String reset(ModelMap model) {
        model.addAttribute("student", new Student());
        model.addAttribute("studentList", dao.findAll());
        return "bai4-java-net-url/index";
    }
}
