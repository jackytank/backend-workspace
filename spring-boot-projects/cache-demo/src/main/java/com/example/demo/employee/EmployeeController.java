package com.example.demo.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<?> getEmployees(
        @RequestParam(defaultValue = "0") Integer no,
        @RequestParam(defaultValue = "10") Integer limit,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(required = false, defaultValue = "true") Boolean desc
    ) {
        return ResponseEntity.ok(employeeService.getAllEmployees(no, limit, sortBy, desc));
    }

    @PostMapping("")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
    
    
}
