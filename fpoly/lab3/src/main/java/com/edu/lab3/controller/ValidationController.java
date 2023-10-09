
package com.edu.lab3.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.lab3.model.Student2;

@Controller
public class ValidationController {

    @RequestMapping("/validation/form")
    public String form(ModelMap model) {
        Student2 student = new Student2();
        model.addAttribute("student", student);
        return "validation/form";
    }

    @PostMapping("/validation/validate")
    public String save(ModelMap model, @Valid @ModelAttribute("student") Student2 form, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Please recheck your input!");
            return "validation/form";
        } else {
            return "validation/success";
        }
    }
}
