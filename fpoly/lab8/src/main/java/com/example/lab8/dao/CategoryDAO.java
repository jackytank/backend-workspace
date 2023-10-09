package com.example.lab8.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab8.entity.Category;

public interface CategoryDAO extends JpaRepository<Category,String> {
}
