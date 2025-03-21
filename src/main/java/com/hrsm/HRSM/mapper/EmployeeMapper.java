package com.hrsm.HRSM.mapper;


import com.hrsm.HRSM.dto.EmployeeDto;
import com.hrsm.HRSM.dto.EmployeeList;
import com.hrsm.HRSM.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {


    public EmployeeList toDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        return new EmployeeList(
                employee.getEmpId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDesignation(),
                employee.getDateOfJoining(),
                employee.getStatus()
        );
    }

    public Employee toEntity(EmployeeDto dto) {
        if (dto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setEmpId(dto.getEmpId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDesignation(dto.getDesignation());
        employee.setDateOfJoining(dto.getDateOfJoining());
        employee.setTotalExperience(dto.getTotalExperience());
        employee.setTeam(dto.getTeam());
        employee.setReportingOffice(dto.getReportingOffice());


        return employee;
    }
}
