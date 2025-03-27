package com.hrsm.HRSM.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {

    private String empId;
    private String name;
    private String email;
    private String designation;
    private LocalDateTime punchIn;
    private LocalDateTime punchOut;
    private Double totalHours;
    private boolean present;


}
