package com.company.employeemanagementrestapi.service;

import com.company.employeemanagementrestapi.data.dto.request.EmployeeRequestDto;
import com.company.employeemanagementrestapi.data.dto.response.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> getAll();

    void save(EmployeeRequestDto employeeRequestDto);

    void updateEmployee(Long id, EmployeeRequestDto employeeRequestDto);

    void deleteEmployee(Long id);
}
