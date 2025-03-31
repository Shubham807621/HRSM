package com.hrsm.HRSM.mapper;


import com.hrsm.HRSM.dto.EmployeeDto;
import com.hrsm.HRSM.dto.EmployeeHRDashBoardDto;
import com.hrsm.HRSM.dto.EmployeeList;
import com.hrsm.HRSM.entity.BasicInfo;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeList toDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        Integer phoneNumber = (employee.getBasicInfo() != null) ? employee.getBasicInfo().getPhoneNumber() : null;

        return EmployeeList.builder()
                .empId(employee.getEmpId())
                .name(employee.getName())
                .email(employee.getEmail())
                .designation(employee.getDesignation())
                .phoneNumber(phoneNumber)
                .dateOfJoining(employee.getDateOfJoining())
                .team(employee.getTeam())
                .status(employee.getStatus())
                .build();
    }


    public EmployeeDto toEmpDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        return new EmployeeDto(
                employee.getEmpId(),
                employee.getName(),
                employee.getEmail(),
                employee.getClientId(),
                employee.getDesignation(),
                employee.getTotalExperience(),
                (employee.getBasicInfo() != null) ? employee.getBasicInfo().getPhoneNumber() : null,
                employee.getTeam(),
                employee.getReportingOffice(),
                employee.getDateOfJoining(),
                employee.getStatus(),
                employee.getTasks(),
                employee.getSkills()

        );
    }

    public EmployeeHRDashBoardDto toEmpDashboardDto(Employee employee){
        if (employee == null){
            return null;
        }
        return new EmployeeHRDashBoardDto(
                employee.getEmpId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDesignation(),
                employee.getTeam()
        );


    }

    // Method to generate new empId
    private String generateEmpId() {
        String lastEmpId = employeeRepo.findLastEmpId(); // Fetch last empId

        int nextIdNumber = 11111; // Default starting number
        if (lastEmpId != null && lastEmpId.startsWith("EMP")) {
            String numberPart = lastEmpId.substring(3); // Extract number from "EMP11111"
            nextIdNumber = Integer.parseInt(numberPart) + 1; // Increment number
        }

        return "EMP" + nextIdNumber; // New empId
    }
    public Employee toEntity(EmployeeDto dto) {
        if (dto == null) {
            return null;
        }

        if(dto.getEmpId() == null) {
            Employee employee = new Employee();
            employee.setEmpId(generateEmpId());
            employee.setName(dto.getName());
            employee.setEmail(dto.getEmail());
            employee.setClientId(dto.getClientId());
            employee.setDesignation(dto.getDesignation());
            employee.setDateOfJoining(dto.getDateOfJoining());
            employee.setTotalExperience(dto.getTotalExperience());
            employee.setTeam(dto.getTeam());
            employee.setStatus(dto.getStatus());
            employee.setReportingOffice(dto.getReportingOffice());
            return employee;

        }
        Employee employee1 = employeeRepo.findByEmpId(dto.getEmpId());
        employee1.setName(dto.getName());
        employee1.setClientId(dto.getClientId());
        employee1.setDesignation(dto.getDesignation());
        employee1.setTotalExperience(dto.getTotalExperience());
        employee1.setBasicInfo(BasicInfo.builder().phoneNumber(dto.getPhoneNumber()).build());
        employee1.setTeam(dto.getTeam());
        employee1.setReportingOffice(dto.getReportingOffice());
        employee1.setDateOfJoining(dto.getDateOfJoining());
        employee1.setStatus(dto.getStatus());
        return employee1;

    }
}
