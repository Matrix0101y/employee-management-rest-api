package com.company.employeemanagementrestapi.data.repository;

import com.company.employeemanagementrestapi.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findEmployeeById(Long id);
}
