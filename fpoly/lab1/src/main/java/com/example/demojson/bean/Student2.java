package com.example.demojson.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student2 {
    private String name;
    private Boolean gender;
    private Double marks;
    private Contact contact;
    private List<String> subjects;
}
