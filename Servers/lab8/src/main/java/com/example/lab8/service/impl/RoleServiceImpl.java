package com.example.lab8.service.impl;

import com.example.lab8.dao.RoleDAO;
import com.example.lab8.entity.Role;
import com.example.lab8.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDAO rDao;


    @Override
    public List<Role> findAll() {
        return rDao.findAll();
    }
}
