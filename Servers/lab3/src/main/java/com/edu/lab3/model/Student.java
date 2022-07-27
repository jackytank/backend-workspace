package com.edu.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String email;
    private String fullname;
    private Double marks;
    private Boolean gender;
    private String country;
}
