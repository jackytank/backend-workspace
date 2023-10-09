package com.edu.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.lab7.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
