package com.example.demojson.app;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.demojson.bean.Contact;
import com.example.demojson.bean.Student2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Jackson2 {
    public static void main(String[] args) throws Exception {
        // demo1();
        // demo2();
        // demo3();
        // demo4();
        // demo5();
        // demo6();
        demo7();
    }

    private static void demo7() throws Exception {
        Contact contact = new Contact("teomv@gmail.com", "0239492323", "29/3 Beverly Hill");
        List<String> subjects = Arrays.asList("WEB203", "COM102");
        Student2 student2 = new Student2("Nguyen Batman", true, 2.5, contact, subjects);

        ObjectMapper mpper = new ObjectMapper();
        String json = mpper.writeValueAsString(student2);

        mpper.writerWithDefaultPrettyPrinter().writeValue(System.out, student2);

        mpper.writeValue(new File("src\\main\\resources\\writeStudent3.json"), student2);

    }

    private static void demo6() throws Exception {
        var contact = new HashMap<String, Object>();
        contact.put("email", "sieunhan@gmail.com");
        contact.put("phone", "0293849283");

        var subjects = Arrays.asList("WEB205", "WEB113");
        var student = new LinkedHashMap<String, Object>();
        student.put("name", "Nguyen Sieu Nhan");
        student.put("marks", 2.3);
        student.put("gender", true);
        student.put("contact", contact);
        student.put("subjects", subjects);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student);
        System.out.println(json);
        System.out.println("---------------");

        mapper.writeValue(System.out, student);
        mapper.writeValue(new File("src\\main\\resources\\writeStudent2.json"), student);

    }

    private static void demo5() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Nguyen Sieu Nhan");
        student.put("marks", 2.3);
        student.put("gender", true);
        ObjectNode contact = student.putObject("contact");
        contact.put("email", "sieunhan@gmail.com");
        contact.put("phone", "0293849283");
        ArrayNode subjects = student.putArray("subjects");
        subjects.add("WEB203");
        subjects.add("COM102");

        String json = mapper.writeValueAsString(student);
        mapper.writeValue(System.out, student);

        mapper.writeValue(new File("src\\main\\resources\\writeStudent.json"), student);
    }

    private static void demo4() throws StreamReadException, DatabindException, IOException {
        String path = "src\\main\\resources\\students.json";
        var type = new TypeReference<List<Student2>>() {
        };

        var mapper = new ObjectMapper();
        List<Student2> students = mapper.readValue(new File(path), type);
        students.forEach(e -> {
            System.out.println(">> Name: " + e.getName());
        });

    }

    private static void demo3() throws StreamReadException, DatabindException, IOException {
        String path = "src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Student2 student = mapper.readValue(new File(path), Student2.class);
        System.out.println(">>Name: " + student.getName());
        System.out.println(">>Marks: " + student.getMarks());
        System.out.println(">>Gender: " + student.getGender());
        Contact contact = student.getContact();
        System.out.println(">>Email: " + contact.getEmail());
        System.out.println(">>Phone: " + contact.getPhone());
        List<String> subjects = student.getSubjects();
        subjects.forEach(sub -> {
            System.out.println("    >>Subject: " + sub);
        });
    }

    private static void demo2() throws StreamReadException, DatabindException, IOException {
        String path = "src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
        students.forEach(student -> {
            System.out.println(">>Name: " + student.get("name"));
            System.out.println(">>Marks: " + student.get("marks"));
            System.out.println(">>Gender: " + student.get("gender"));
            Map<String, Object> contact = (Map<String, Object>) student.get("contact");
            System.out.println(">>Email: " + contact.get("email"));
            System.out.println(">>Phone: " + contact.get("phone"));
            List<String> subjects = (List<String>) student.get("subjects");
            subjects.forEach(subject -> {
                System.out.println("  >Subject: " + subject);
            });
            System.out.println();
        });

    }

    private static void demo1() throws Exception {
        String path = "src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> student = mapper.readValue(new File(path), Map.class);
        System.out.println(">>Name: " + student.get("name"));
        System.out.println(">>Marks: " + student.get("marks"));
        System.out.println(">>Gender: " + student.get("gender"));
        Map<String, Object> contact = (Map<String, Object>) student.get("contact");
        System.out.println(">>Email: " + contact.get("email"));
        System.out.println(">>Phone: " + contact.get("phone"));
        List<String> subjects = (List<String>) student.get("subjects");
        subjects.forEach(subject -> {
            System.out.println("  >Subject: " + subject);
        });

    }
}
