package com.example.demojson.app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson1 {

    public static void main(String[] args) throws Exception {
        // demo1();
        demo2();      int a = 100;
        {
           int b = 200;
           System.out.print(a + ", " + b);
        }
        {
           a = 150;
           b = 100;
           System.out.print(" - " + a + ", " + b);
        }
        System.out.print(" - " + a + ", " + b);
     }
    }

    private static void demo2() throws IOException {
        String path = "src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode students = mapper.readTree(new File(path));
        students.forEach(student -> {
            System.out.println(">>Name: " + student.get("name").asText());
            System.out.println(">>Marks: " + student.get("marks").asDouble());
            System.out.println(">>Gender: " + student.get("gender").asBoolean());
            System.out.println(">>Email: " + student.get("contact").get("email").asText());
            System.out.println(">>Phone: " + student.findValue("phone").asText());
            student.get("subjects").iterator().forEachRemaining(subject -> {
                System.out.println("    >>Subject: " + subject.asText());
            });
            System.out.println();
        });
    }

    private static void demo1() throws Exception {
        String path = "src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(path));
        System.out.println(">>Name: " + student.get("name").asText());
        System.out.println(">>Marks: " + student.get("marks").asDouble());
        System.out.println(">>Gender: " + student.get("gender").asBoolean());
        System.out.println(">>Email: " + student.get("contact").get("email").asText());
        System.out.println(">>Phone: " + student.findValue("phone").asText());
        student.get("subjects").iterator().forEachRemaining(subject -> {
            System.out.println(">>Subject: " + subject.asText());
        });

    }
}