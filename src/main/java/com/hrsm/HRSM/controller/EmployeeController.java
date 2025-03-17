package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.dto.EmployeeDto;
import com.hrsm.HRSM.dto.EmployeeList;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employeelist")
    public ResponseEntity<List<EmployeeList>> getAllEmployeesList() {
        return ResponseEntity.ok(employeeService.getAllEmployeesList());
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee1 = employeeService.addEmployee(employeeDto);

        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @GetMapping("/employee/detail/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String empId){

        Employee employee = employeeService.getEmployeeDetailsByEmpId(empId);

        return new ResponseEntity<>(employee, HttpStatus.OK);

    }


}
