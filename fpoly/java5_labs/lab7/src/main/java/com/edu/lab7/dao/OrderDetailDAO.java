package com.edu.lab7.dao;

import com.edu.lab7.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
}