package com.edu.lab7.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.edu.lab7.entity.Authority;
import com.edu.lab7.repository.AccountRepository;
import com.edu.lab7.repository.AuthorityRepository;
import com.edu.lab7.repository.RoleRepository;

@RestController
public class AuthorityRestController {
    @Autowired
    RoleRepository roleRepo;
    @Autowired
    AuthorityRepository authorityRepo;
    @Autowired
    AccountRepository accountRepo;

    @GetMapping("/rest/authorities")
    public Map<String, Object> getAuthorities() {
        Map<String, Object> data = new HashMap<>();
        data.put("authorities", authorityRepo.findAll());
        data.put("roles", roleRepo.findAll());
        data.put("accounts", accountRepo.findAll());
        return data;
    }


    @PostMapping("/rest/authorities")
    public Authority create(@RequestBody Authority authority) {
        return authorityRepo.save(authority);

    }

    @DeleteMapping("/rest/authorities/{id}")
    public void delete(@PathVariable("id") Integer id) {
        authorityRepo.deleteById(id);
    }


}
