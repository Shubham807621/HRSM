package com.hrsm.HRSM.dto;


import com.hrsm.HRSM.entity.LeaveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequestDto {
    private UUID id;
    private String empId;
    private String name;
    private String email;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveType;
    private int numberOfDays;
    private LeaveStatus status;
}
