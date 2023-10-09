package com.example.lab8.service;

import com.example.lab8.entity.Account;

import java.util.List;

public interface AccountService {
    Account findById(String username);

    List<Account> getAdministators();

    List<Account> findAll();
}
