package com.edu.lab5.controller;

import com.edu.lab5.dao.ProductDAO;
import com.edu.lab5.entity.Product;
import com.edu.lab5.entity.Report;
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

/**
 * ReportController
 */
@Controller
public class ReportController {
    @Autowired
    ProductDAO dao;

    @RequestMapping("/report/inventory-by-category/")
    public String inventory(ModelMap model) {
        List<Report> items = dao.getInventoryByCategory();
        model.addAttribute("items", items);
        return "report/inventory-by-category";
    }
}