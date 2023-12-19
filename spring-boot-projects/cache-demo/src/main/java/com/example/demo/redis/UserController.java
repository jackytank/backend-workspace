package com.example.demo.redis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> all() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }
}
