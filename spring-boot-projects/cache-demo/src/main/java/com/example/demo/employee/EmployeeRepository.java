package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    boolean existsByEmployeeCode(String employeeCode);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
    
}
