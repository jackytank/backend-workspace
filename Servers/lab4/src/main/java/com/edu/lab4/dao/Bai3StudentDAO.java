package com.edu.lab4.dao;

import org.springframework.stereotype.Service;

import com.edu.lab4.model.Student;
import com.edu.lab4.model.StudentMap;
import com.edu.lab4.rest.Rest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Bai3StudentDAO {
    ObjectMapper mapper = new ObjectMapper();

    public StudentMap findAll() {
        JsonNode resp = Rest.get("/students");
        return mapper.convertValue(resp, StudentMap.class);
    }

    public Student findByKey(String key) {
        JsonNode resp = Rest.get("/students/" + key);
        return mapper.convertValue(resp, Student.class);
    }

    public String create(Student data) {
        JsonNode resp = Rest.post("/students", data);
        return resp.get("name").asText();
    }

    public Student update(String key, Student data) {
        JsonNode resp = Rest.put("/students/" + key, data);
        return mapper.convertValue(resp, Student.class);
    }

    public void delete(String key) {
        Rest.delete("/students/" + key);
    }
}
