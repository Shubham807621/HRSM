package com.hrsm.HRSM.dto;


import com.hrsm.HRSM.entity.EmployeeStatus;
import com.hrsm.HRSM.entity.Skill;
import com.hrsm.HRSM.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String empId;
    private String name;
    private String email;
    private String clientId;
    private String designation;
    private String totalExperience;
    private Integer phoneNumber;
    private String team;
    private String reportingOffice;
    private LocalDate dateOfJoining;
    private EmployeeStatus status;
    private List<Task> tasks;
    private List<Skill> skills;


}
