package com.example.lab8.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab8.dao.CategoryDAO;
import com.example.lab8.entity.Category;
import com.example.lab8.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO dao;

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

}
