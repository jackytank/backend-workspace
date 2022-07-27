package com.edu.lab4.dao;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.edu.lab4.model.Student;
import com.edu.lab4.model.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;

@Repository
public class Bai4StudentDAO {
    RestTemplate rest = new RestTemplate();

    String url = "https://poly-java-6-58f2f-default-rtdb.asia-southeast1.firebasedatabase.app/students.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public StudentMap findAll() {
        return rest.getForObject(url, StudentMap.class);
    }

    public Student findByKey(String key) {
        return rest.getForObject(getUrl(key), Student.class);
    }

    public String create(Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText();
    }

    public Student update(String key, Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        rest.put(getUrl(key), entity);
        return data;
    }

    public void delete(String key) {
        rest.delete(getUrl(key));
    }
}
