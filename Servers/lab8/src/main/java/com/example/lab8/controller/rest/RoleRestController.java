package com.example.lab8.controller.rest;

import com.example.lab8.entity.Role;
import com.example.lab8.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RoleRestController {
    @Autowired
    RoleService roleService;

    @GetMapping("/rest/roles")
    public List<Role> getAll(){
        return roleService.findAll();
    }
}