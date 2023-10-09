
package com.edu.lab5.dao;
import com.edu.lab5.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer>{

}
