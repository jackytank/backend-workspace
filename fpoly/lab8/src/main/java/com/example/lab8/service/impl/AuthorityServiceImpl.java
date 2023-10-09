package com.example.lab8.service.impl;

import com.example.lab8.dao.AccountDAO;
import com.example.lab8.dao.AuthorityDAO;
import com.example.lab8.entity.Account;
import com.example.lab8.entity.Authority;
import com.example.lab8.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityDAO aDao;

    @Autowired
    AccountDAO acDao;


    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        List<Account> accounts = acDao.getAdministrators();
        return aDao.authoritiesOf(accounts);
    }

    @Override
    public List<Authority> findAll() {
        return aDao.findAll();
    }

    @Override
    public Authority create(Authority auth) {
        return aDao.save(auth);
    }

    @Override
    public void delete(Integer id) {
        aDao.deleteById(id);
    }
}
