package com.example.lab8.controller.rest;

import com.example.lab8.entity.Authority;
import com.example.lab8.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class AuthorityRestController {
    @Autowired
    AuthorityService authorityService;

    @GetMapping("/rest/authorities")
    public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return authorityService.findAuthoritiesOfAdministrators();
        }
        return authorityService.findAll();
    }

    @PostMapping("/rest/authorities")
    public Authority post(@RequestBody Authority auth) {
        return authorityService.create(auth);
    }

    @DeleteMapping("/rest/authorities/{id}")
    public void delete(@PathVariable("id") Integer id) {
        authorityService.delete(id);
    }
}
