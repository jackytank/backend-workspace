package com.edu.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.lab7.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String>{
    
}
