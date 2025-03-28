package com.hrsm.HRSM.mapper;

import com.hrsm.HRSM.dto.AttendanceDto;
import com.hrsm.HRSM.dto.LeaveRequestDto;
import com.hrsm.HRSM.entity.Attendance;
import com.hrsm.HRSM.entity.LeaveRequest;
import com.hrsm.HRSM.repo.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeaveMapper {

    @Autowired
    private LeaveRepo leaveRepo;

    public LeaveRequestDto toDto(LeaveRequest leaveRequest){

        return LeaveRequestDto.builder()
                .id(leaveRequest.getId())
                .empId(leaveRequest.getEmployee().getEmpId())
                .designation(leaveRequest.getEmployee().getDesignation())
                .name(leaveRequest.getEmployee().getName())
                .email(leaveRequest.getEmployee().getEmail())
                .startDate(leaveRequest.getStartDate())
                .endDate(leaveRequest.getEndDate())
                .leaveType(leaveRequest.getLeaveType())
                .numberOfDays(leaveRequest.getNumberOfDays())
                .status(leaveRequest.getStatus())
                .build();
    }
}
