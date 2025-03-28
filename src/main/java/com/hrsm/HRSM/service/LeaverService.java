package com.hrsm.HRSM.service;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.dto.LeaveCountDto;
import com.hrsm.HRSM.dto.LeaveRequestDto;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.LeaveRequest;
import com.hrsm.HRSM.entity.LeaveStatus;
import com.hrsm.HRSM.mapper.LeaveMapper;
import com.hrsm.HRSM.repo.EmployeeRepo;
import com.hrsm.HRSM.repo.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LeaverService {

    @Autowired
    private LeaveRepo leaveRepo;


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private LeaveMapper leaveMapper;


    public List<LeaveRequest> getAllLeaves(String empId) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with empId: " + empId);
        }

        return leaveRepo.findAllByEmployeeId(employee.getId());
    }


    public LeaveRequest updateLeaveByID(String empId, UUID id, LeaveStatus status) {
        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with empId: " + empId);
        }

        // Find the latest leave request for the employee
        LeaveRequest leaveRequest = leaveRepo.findById(id).orElse(null);

        if (leaveRequest == null) {
            throw new RuntimeException("No leave request found for empId: " + empId);
        }

        // Update the status of the leave request
        leaveRequest.setStatus(status);

        // Save the updated leave request
        return leaveRepo.save(leaveRequest);
    }

    public LeaveRequest create(LeaveRequest leaveRequest, String empId) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null) {
            throw new RuntimeException("Employee not found with empId: " + empId);
        }

        // Calculate number of leave days
        int numberOfDays = (int) ChronoUnit.DAYS.between(leaveRequest.getStartDate(), leaveRequest.getEndDate()) + 1;

        LeaveRequest leaveRequest1 = LeaveRequest.builder()
                .employee(employee)
                .startDate(leaveRequest.getStartDate())
                .endDate(leaveRequest.getEndDate())
                .status(leaveRequest.getStatus())
                .reason(leaveRequest.getReason())
                .leaveType(leaveRequest.getLeaveType())
                .numberOfDays(numberOfDays) // Setting calculated leave days
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


    public List<LeaveRequestDto> getALl() {
        List<LeaveRequest> leaveRequests = leaveRepo.findAll();
        return leaveRequests.stream().map(leaveMapper::toDto).collect(Collectors.toList());
    }
}
