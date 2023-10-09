package com.example.lab8.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab8.entity.Role;

public interface RoleDAO extends JpaRepository<Role,String> {
}
