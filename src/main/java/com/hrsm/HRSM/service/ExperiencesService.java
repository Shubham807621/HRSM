package com.hrsm.HRSM.service;

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
}
