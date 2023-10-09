package com.edu.lab2.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Boolean gender = false;
    private Double marks = 0.0;
    private Contact contact;
    private List<String> subjects;
    
}
