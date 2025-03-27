package com.hrsm.HRSM.mapper;

import com.hrsm.HRSM.dto.AttendanceDto;
import com.hrsm.HRSM.entity.Attendance;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.repo.AttendanceRepo;
import com.hrsm.HRSM.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {

    @Autowired
    private AttendanceRepo attendanceRepo;

    public AttendanceDto toDto(Attendance attendance){


        return AttendanceDto.builder()
                .empId(attendance.getEmployee().getEmpId())
                .name(attendance.getEmployee().getName())
                .email(attendance.getEmployee().getEmail())
                .designation(attendance.getEmployee().getDesignation())
                .punchIn(attendance.getPunchIn())
                .punchOut(attendance.getPunchOut())
                .totalHours(attendance.getTotalHours())
                .present(attendance.isPresent())
                .build();

    }


}
