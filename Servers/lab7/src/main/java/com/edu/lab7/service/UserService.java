package com.edu.lab7.service;

import com.edu.lab7.entity.Account;
import com.edu.lab7.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepo;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account account = accountRepo.findById(username).get();
            //tao UserDetails tu Account
            String password = account.getPassword();
            String[] roles = account.getAuthorities().stream()
                    .map(authority -> authority.getRole().getId())
                    .collect(Collectors.toList()).toArray(new String[0]);
            return User.withUsername(username)
                    .password(encoder.encode(password))
                    .roles(roles)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
