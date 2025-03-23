package com.hrsm.HRSM.dto;


import com.hrsm.HRSM.entity.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String empId;
    private String name;
    private String email;
    private String designation;
    private String totalExperience;
    private int phoneNumber;
    private String team;
    private String reportingOffice;
    private LocalDate dateOfJoining;
    private EmployeeStatus status;


}
