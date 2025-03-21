package com.hrsm.HRSM.service;


import com.hrsm.HRSM.entity.Department;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.repo.DepartmentRepo;
import com.hrsm.HRSM.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public Department createDepartment(Department department, String empId) {

        Employee employee = employeeRepo.findByEmpId(empId);

        Department department1 = Department.builder()
                .employee(employee)
                .name(department.getName())
                .build();

        return departmentRepo.save(department1);
    }
}
