package com.edu.lab4.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable{
    private String email;
    private String fullname;
    private Double marks;
    private Boolean gender;
    private String country;

    @JsonIgnore
    public Object[] getArray() {
        return new Object[] {
                getEmail(),
                getFullname(),
                getMarks(),
                getGender(),
                getCountry()
        };
    }
}
