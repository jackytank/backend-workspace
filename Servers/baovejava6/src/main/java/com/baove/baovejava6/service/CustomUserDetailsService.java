package com.baove.baovejava6.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baove.baovejava6.entity.User;
import com.baove.baovejava6.repository.UserRepository;

@Service

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findById(username);
        user.orElseThrow(() -> new RuntimeException("User not found: " + username));
        return user.map(CustomUserDetails::new).get();
    }

    // @Transactional
    // public UserDetails loadUserById(Integer id) {
    // Optional<User> user = userRepo.findById(id);
    // user.orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    // return user.map(CustomUserDetails::new).get();
    // }

}
