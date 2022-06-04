package com.edu.lab5.dao;

import com.edu.lab5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer>{

}
