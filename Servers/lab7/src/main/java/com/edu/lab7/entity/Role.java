package com.edu.lab7.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    private String id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<Authority> authorities;
}
