package com.hrsm.HRSM.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeHRDashBoardDto {
    private String empId;
    private String name;
    private String email;
    private String designation;
    private String team;
}
