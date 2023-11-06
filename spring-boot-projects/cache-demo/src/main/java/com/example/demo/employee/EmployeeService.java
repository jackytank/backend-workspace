package com.example.demo.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    private static AtomicInteger count = new AtomicInteger(0);

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        // populateEmployees();
    }

    @Cacheable(value = "employees", key = "#no + '-' + #limit + '-' + #sortBy + '-' + #desc")
    public Page<Employee> getAllEmployees(Integer no, Integer limit, String sortBy, Boolean desc) {
        log.info("Fetching employees from database, count time: {}", count.incrementAndGet());
        Sort sort = Sort.by(Boolean.TRUE.equals(desc) ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy);
        Pageable pageable = PageRequest.of(no, limit, sort);
        return employeeRepository.findAll(pageable);
    }

    public Employee createEmployee(Employee employee) {
        log.info("Creating employee: {}", employee);
        // check if employee code already exists
        if (employeeRepository.existsByEmployeeCode(employee.getEmployeeCode())) {
            throw new RuntimeException("Employee code already exists");
        }
        // check if email already exists
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        // check if phone already exists
        if (employeeRepository.existsByPhone(employee.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        log.info("Deleting employee with id: {}", id);
        // check if employee exists
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        employeeRepository.deleteById(id);
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
