package com.hrsm.HRSM.service;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.dto.LeaveCountDto;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.LeaveRequest;
import com.hrsm.HRSM.repo.EmployeeRepo;
import com.hrsm.HRSM.repo.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaverService {

    @Autowired
    private LeaveRepo leaveRepo;


    @Autowired
    private EmployeeRepo employeeRepo;

    public LeaveRequest create(LeaveRequest leaveRequest, String empId) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with empId: " + empId);
        }

        LeaveRequest leaveRequest1= LeaveRequest.builder()
                .employee(employee)
                .startDate(leaveRequest.getStartDate())
                .endDate(leaveRequest.getEndDate())
                .status(leaveRequest.getStatus())
                .reason(leaveRequest.getReason())
                .leaveType(leaveRequest.getLeaveType())
                .build();

        return leaveRepo.save(leaveRequest1);
    }


    public RegistrationResponse deleteLeave(String empId) {
        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with empId: " + empId);
        }

        LeaveRequest leaveRequest = leaveRepo.findByEmployee(employee);

        leaveRepo.deleteById(leaveRequest.getId());

        return RegistrationResponse.builder()
                .code(200)
                .message("Leave Has Been deleted")
                .build();
    }

    public LeaveCountDto getLeaveCounts(String empId) {
        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with empId: " + empId);
        }
        System.out.println("Employee ID: " + employee.getId()); // ✅ Debugging
        return leaveRepo.countLeaveRequestsByType(employee.getId());
    }
}
