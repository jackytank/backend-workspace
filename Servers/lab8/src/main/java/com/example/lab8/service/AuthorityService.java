package com.example.lab8.service;

import com.example.lab8.entity.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> findAuthoritiesOfAdministrators();

    List<Authority> findAll();

    Authority create(Authority auth);

    void delete(Integer id);
}
