package com.edu.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.lab7.entity.Account;

public interface AccountRepository extends JpaRepository<Account,String>{
    
}
