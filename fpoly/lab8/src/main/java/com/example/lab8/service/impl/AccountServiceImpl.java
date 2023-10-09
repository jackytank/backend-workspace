package com.example.lab8.service.impl;

import com.example.lab8.dao.AccountDAO;
import com.example.lab8.entity.Account;
import com.example.lab8.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDAO dao;

    @Override
    public Account findById(String username) {
        return dao.findById(username).get();
    }

    @Override
    public List<Account> getAdministators() {
        return dao.getAdministrators();
    }

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }
}
