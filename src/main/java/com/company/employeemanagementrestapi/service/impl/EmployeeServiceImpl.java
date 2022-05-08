package com.company.employeemanagementrestapi.service.impl;

import com.company.employeemanagementrestapi.config.ModelMapperConfiguration;
import com.company.employeemanagementrestapi.data.dto.request.EmployeeRequestDto;
import com.company.employeemanagementrestapi.data.dto.response.EmployeeResponseDto;
import com.company.employeemanagementrestapi.data.entity.Employee;
import com.company.employeemanagementrestapi.data.repository.EmployeeRepository;
import com.company.employeemanagementrestapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponseDto> getAll() {

        return employeeRepository.findAll().stream().map(employee -> ModelMapperConfiguration.map(employee, EmployeeResponseDto.class)).collect(Collectors.toList());

//            List<Employee> employees = employeeRepository.findAll();
//            return employees.stream().map(employee -> ModelMapperConfiguration.map(employee,EmployeeResponseDto.class)).collect(Collectors.toList());

        //second way
//        List<Employee> employees = employeeRepository.findAll();
//        List<EmployeeResponseDto> returnValue = new ArrayList<>();
//
//        employees.forEach(employee -> {
//            EmployeeResponseDto employeeResponseDto = ModelMapperConfiguration.map(employee,EmployeeResponseDto.class);
//            returnValue.add(employeeResponseDto);
//        });
//        return returnValue;


    }

    @Override
    public void save(EmployeeRequestDto employeeRequestDto) {
        employeeRepository.save(ModelMapperConfiguration.map(employeeRequestDto, Employee.class));
    }

    @Override
    public void updateEmployee(Long id, EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeRepository.findEmployeeById(id);
        Employee updatedEmployee = ModelMapperConfiguration.map(employeeRequestDto, employee);
//        updatedEmployee.setUpdatedDate(new Date());
        employeeRepository.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

}
