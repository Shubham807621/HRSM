package com.hrsm.HRSM.service;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.Experience;
import com.hrsm.HRSM.repo.EmployeeRepo;
import com.hrsm.HRSM.repo.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperiencesService {

    @Autowired
    private ExperienceRepo experienceRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public Experience addExperience(String empId, Experience experience) {
        Employee employee = employeeRepo.findByEmpId(empId);

        Experience experience1 = Experience.builder()
                .employee(employee)
                .companyName(experience.getCompanyName())
                .role(experience.getRole())
                .duration(experience.getDuration())
                .build();

        return experienceRepo.save(experience1);
    }

    public RegistrationResponse updateDetails(String empId, Experience experience) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null){
            return RegistrationResponse.builder().code(400).message("Employee Not  Found").build();

        }

        Experience experience1 = experienceRepo.findByEmployee(employee);

        if (experience1 != null){
            experience1.setCompanyName(experience.getCompanyName());
            experience1.setRole(experience.getRole());
            experience1.setDuration(experience.getDuration());

            experienceRepo.save(experience1);
        }
        else {
            Experience experience2 = Experience.builder()
                    .employee(employee)
                    .companyName(experience.getCompanyName())
                    .role(experience.getRole())
                    .duration(experience.getDuration())
                    .build();

            experienceRepo.save(experience2);

        }

        return RegistrationResponse.builder().code(201).message("Details Updated For the User").build();


    }
}
