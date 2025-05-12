package com.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeManagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Extends JpaRepository to provide CRUD operations for Employee
}
