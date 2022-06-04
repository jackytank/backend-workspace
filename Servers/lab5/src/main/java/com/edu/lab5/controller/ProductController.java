package com.edu.lab5.controller;

import com.edu.lab5.dao.ProductDAO;
import com.edu.lab5.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductDAO dao;

    @RequestMapping("/sort")
    public String sort(ModelMap model, @RequestParam("field") Optional<String> field) {
        Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
        model.addAttribute("field", field.orElse("price").toUpperCase());
        List<Product> products = dao.findAll(sort);
        model.addAttribute("products", products);
        return "/sort/index";
    }

    @RequestMapping("/page")
    public String paginate(ModelMap model, @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<Product> pages = dao.findAll(pageable);
        model.addAttribute("page", pages);
        return "/pagination/index";
    }
}
