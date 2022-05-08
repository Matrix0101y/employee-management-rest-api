package com.company.employeemanagementrestapi.controller;

import com.company.employeemanagementrestapi.data.dto.request.EmployeeRequestDto;
import com.company.employeemanagementrestapi.data.dto.response.EmployeeResponseDto;
import com.company.employeemanagementrestapi.enums.MessageCase;
import com.company.employeemanagementrestapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.company.employeemanagementrestapi.enums.MessageCase.EMPLOYEE_CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.save(employeeRequestDto);
        return new ResponseEntity<>(EMPLOYEE_CREATED.getMessage(), HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.updateEmployee(id, employeeRequestDto);
        return ResponseEntity.ok(MessageCase.EMPLOYEE_UPDATED.getMessage());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(MessageCase.EMPLOYEE_DELETED.getMessage());
    }


}
