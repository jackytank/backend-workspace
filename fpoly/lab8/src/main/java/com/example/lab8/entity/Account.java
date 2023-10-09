package com.example.lab8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    String username;
    String password;
    String fullname;
    String email;
    String photo;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    List<Authority> authorities;
}
