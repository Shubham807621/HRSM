package com.hrsm.HRSM.service;

import com.hrsm.HRSM.dto.EmployeeDto;
import com.hrsm.HRSM.dto.EmployeeList;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.mapper.EmployeeMapper;
import com.hrsm.HRSM.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee addEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toEntity((employeeDto));

        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    public List<EmployeeList> getAllEmployeesList() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll() ;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }




}
