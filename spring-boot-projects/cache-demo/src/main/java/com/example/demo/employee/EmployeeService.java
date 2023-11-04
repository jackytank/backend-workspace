package com.example.demo.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        // populateEmployees();
    }

    @Cacheable(value = "employees", key = "#no + '-' + #limit + '-' + #sortBy + '-' + #desc")
    public Page<Employee> getAllEmployees(Integer no, Integer limit, String sortBy, Boolean desc) {
        Sort sort = Sort.by(Boolean.TRUE.equals(desc) ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy);
        Pageable pageable = PageRequest.of(no, limit, sort);
        return employeeRepository.findAll(pageable);
    }

    public void populateEmployees() {
        // starting to populate 5000 employees using javafaker
        Faker faker = new Faker();
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            Employee employee = Employee.builder()
                    .employeeCode(faker.number().digits(5))
                    .jobTitle(faker.job().title())
                    .name(faker.name().fullName())
                    .phone(faker.phoneNumber().phoneNumber())
                    .imageUrl(faker.internet().image())
                    .email(faker.internet().emailAddress())
                    .build();
            employeeList.add(employee);
            System.out.println("Employee " + i + " added");
        }
        employeeRepository.saveAll(employeeList);
    }

}
