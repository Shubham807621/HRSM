package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.entity.Department;
import com.hrsm.HRSM.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department/{empId}")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department, @PathVariable String empId){
        Department department1 = departmentService.createDepartment(department, empId);

        return new ResponseEntity<>(department1, HttpStatus.CREATED);

    }

}
