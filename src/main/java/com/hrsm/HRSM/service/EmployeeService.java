package com.hrsm.HRSM.service;

import com.hrsm.HRSM.dto.EmployeeDto;
import com.hrsm.HRSM.dto.EmployeeList;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.helper.EmployeeDepartmentCount;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(EmployeeDto employeeDto);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);

    List<EmployeeList> getAllEmployeesList();

    Employee getEmployeeDetailsByEmpId(String empId);

    Long totalEmployees();

    List<EmployeeDepartmentCount> getAllEmployeeCounts();
}
