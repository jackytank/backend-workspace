package com.example.demo.employee;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

interface EmployeeService {
    List<Employee> getAllEmployees();
}

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
