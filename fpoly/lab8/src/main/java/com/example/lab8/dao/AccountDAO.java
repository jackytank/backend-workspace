package com.example.lab8.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.lab8.entity.Account;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account,String> {
    @Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
    List<Account> getAdministrators();
}
