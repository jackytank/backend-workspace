package com.edu.lab5.controller;

import com.edu.lab5.dao.ProductDAO;
import com.edu.lab5.entity.Product;
import com.edu.lab5.service.SessionService;

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

    @Autowired
    SessionService sessionService;

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

    @RequestMapping("/search")
    public String search(ModelMap model,
            @RequestParam("min") Optional<Double> min,
            @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "search/search";
    }

    @RequestMapping("/search-and-page")
    public String searchAndPage(ModelMap model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("keywords") Optional<String> kw) {
        String keywords = kw.orElse(sessionService.get("keywords"));
        sessionService.set("keywords", keywords);

        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<Product> pages = dao.findAllByNameLike("%" + keywords + "%", pageable);
        model.addAttribute("page", pages);
        return "search/search_and_page";
    }

    @RequestMapping("/search-dsl")
    public String search_dsl(ModelMap model,
            @RequestParam("min") Optional<Double> min,
            @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "search/search_dsl";
    }

    @RequestMapping("/search-and-page-dsl")
    public String searchAndPageDSL(ModelMap model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("keywords") Optional<String> kw) {
        String keywords = kw.orElse(sessionService.get("keywords"));
        sessionService.set("keywords", keywords);

        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<Product> pages = dao.findAllByNameLike("%" + keywords + "%", pageable);
        model.addAttribute("page", pages);
        return "search/search_and_page_dsl";
    }
}
