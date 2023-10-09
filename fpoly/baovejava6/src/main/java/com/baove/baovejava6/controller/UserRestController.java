package com.baove.baovejava6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baove.baovejava6.entity.User;
import com.baove.baovejava6.entity.UserRole;
import com.baove.baovejava6.repository.RoleRepository;
import com.baove.baovejava6.repository.UserRepository;
import com.baove.baovejava6.repository.UserRoleRepository;

@CrossOrigin("*")
@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepo;
    @Autowired
    UserRoleRepository userRoleRepo;
    @Autowired
    RoleRepository roleRepo;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestParam("admin") Optional<Boolean> admin) {
        if (admin.orElse(false)) {
            return ResponseEntity.ok(userRepo.findAll());
        }
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping("/rest/users")
    public List<User> getAll(ModelMap model, @RequestParam("query") Optional<String> query) {
        if (query.isPresent()) {
            return userRepo.searchUser(query.get());
        }
        return userRepo.findAll();
    }

    @GetMapping("/rest/authorities/users/{id}")
    public List<UserRole> getAllAuthorities(@PathVariable String id) {
        return userRoleRepo.authoritiesOf(id);
    }

    @GetMapping("/rest/users/{id}")
    public User getOne(@PathVariable String id) {
        return userRepo.findById(id).get();
    }

    @PostMapping("/rest/users")
    public User post(@RequestBody User user, @RequestParam("role") Optional<String> role) {
        User oldUser = userRepo.findById(user.getId()).get();
        if (!user.getPassword().equals(oldUser.getPassword())) {
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);

        UserRole userRole = new UserRole(user, roleRepo.findById(role.orElse("USER")).get());
        userRoleRepo.save(userRole);
        return user;
    }

    @PutMapping("/rest/users/{id}")
    public User put(@PathVariable String id, @RequestBody User user) {
        User oldUser = userRepo.findById(id).get();
        if (!user.getPassword().equals(oldUser.getPassword())) {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        userRepo.save(user);
        return user;
    }

    @DeleteMapping("/rest/users/{id}")
    public void delete(@PathVariable String id) {
        userRepo.deleteById(id);
    }

}
