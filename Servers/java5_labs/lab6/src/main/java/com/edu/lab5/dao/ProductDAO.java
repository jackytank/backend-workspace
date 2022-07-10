package com.edu.lab5.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.lab5.entity.Product;
import com.edu.lab5.entity.Report;

public interface ProductDAO extends JpaRepository<Product, Integer> {

    // @Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
    List<Product> findByPriceBetween(double min, double max);

    // @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    @Query("SELECT new Report(o.categoryid, sum(o.price), count(o)) FROM Product o GROUP BY o.categoryid ORDER BY sum(o.price) DESC")
    List<Report> getInventoryByCategory();

    Page<Product> findAllByIdIs(Integer keywords, Pageable pageable);

    // bai 6
    @Query("SELECT o FROM Product o WHERE o.name LIKE %?1%"
            + " OR o.id LIKE %?1%"
            + " OR o.price LIKE %?1%"
            + " OR o.createdate LIKE %?1%")
    Page<Product> findAllThings(String keywords, Pageable pageable);

    Page<Product> findAllByPriceIs(Double keywords, Pageable pageable);
}
