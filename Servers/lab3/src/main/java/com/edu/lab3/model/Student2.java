package com.edu.lab3.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    @NotBlank(message = "{NotBlank.sv.email}")
    @Email(message = "Email is not valid!")
    private String email;
    @NotBlank(message = "Fullname shoudn't be blank!")
    private String fullname;
    @NotNull(message = "Marks should be empty!")
    @PositiveOrZero(message = "Marks must be greater or equal to 0")
    @Max(value = 10, message = "Marks must be lesser than 10")
    private Double marks;
    @NotNull(message = "Please choose gender")
    private Boolean gender;
    @NotBlank(message = "Please choose country")
    private String country;
}
