package com.edu.lab5.dao;


import com.edu.lab5.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, String>{

}
