package com.edu.lab5.controller;

import com.edu.lab5.dao.CategoryDAO;
import com.edu.lab5.entity.Category;
import com.edu.lab5.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryDAO dao;

    @Autowired
    ParamService paramService;

    @GetMapping("/index")
    public String index(ModelMap model) {
        model.addAttribute("category", new Category());
        List<Category> categories = dao.findAll();
        model.addAttribute("categories", categories);
        return "category/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap model) {
        Category category = dao.findById(id).get();
        System.out.println(category.getName());
        model.addAttribute("category", category);
        List<Category> categories = dao.findAll();
        model.addAttribute("categories", categories);
        return "/category/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        dao.deleteById(id);
        return "redirect:/category/index";
    }

    @PostMapping("/update")
    public String update(Category category) {
        dao.save(category);
        return "redirect:/category/edit/" + category.getId();
    }

    @PostMapping("/create")
    public String create(Category category) {
        dao.save(category);
        return "redirect:/category/index";
    }

}
