package com.edu.lab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.lab4.dao.Bai4StudentDAO;
import com.edu.lab4.model.Student;

@Controller
public class Bai4Controller {
    @Autowired
    Bai4StudentDAO dao;

    @RequestMapping("/student/index")
    public String index(ModelMap model) {
        model.addAttribute("student", new Student("", "", 0.0, true, "VN"));
        model.addAttribute("studentList", dao.findAll());
        return "bai5-rest-template/index";
    }

    @RequestMapping("/student/edit/{key}")
    public String edit(ModelMap model, @PathVariable String key) {
        model.addAttribute("key", key);
        model.addAttribute("student", dao.findByKey(key));
        model.addAttribute("studentList", dao.findAll());
        return "bai5-rest-template/index";
    }

    @RequestMapping("/student/create")
    public String create(ModelMap model, @ModelAttribute Student student) {
        dao.create(student);
        model.addAttribute("message", "Created success!");
        return "redirect:/student/index";
    }

    @RequestMapping("/student/update/{key}")
    public String update(ModelMap model, @ModelAttribute Student student, @PathVariable String key) {
        dao.update(key, student);
        return "redirect:/student/edit/" + key;
    }

    @RequestMapping("/student/delete/{key}")
    public String delete(ModelMap model, @PathVariable String key) {
        dao.delete(key);
        return "redirect:/student/index";
    }
}
