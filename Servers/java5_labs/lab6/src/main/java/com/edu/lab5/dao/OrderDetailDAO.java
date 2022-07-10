package com.edu.lab5.dao;

import com.edu.lab5.entity.Orderdetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDAO extends JpaRepository<Orderdetail, Integer>{

}
