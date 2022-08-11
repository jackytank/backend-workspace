package com.example.lab8.controller.rest;

import com.example.lab8.entity.Account;
import com.example.lab8.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class AccountRestController {
    @Autowired
    AccountService accountService;

    @GetMapping("/rest/accounts")
    public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
        if (admin.orElse(false)){
            return accountService.getAdministators();
        }
        return accountService.findAll();
    }
}