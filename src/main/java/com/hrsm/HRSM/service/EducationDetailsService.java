package com.hrsm.HRSM.service;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.EducationDetails;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.repo.EducationDetailsRepo;
import com.hrsm.HRSM.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationDetailsService {

    @Autowired
    private EducationDetailsRepo educationDetailsRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public RegistrationResponse createDetails(String empId, EducationDetails educationDetails) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null){
            return RegistrationResponse.builder().code(400).message("User Not Found").build();
        }

        EducationDetails educationDetails1 = EducationDetails.builder()
                .institution(educationDetails.getInstitution())
                .degree(educationDetails.getDegree())
                .employee(employee)
                .yearOfPassing(educationDetails.getYearOfPassing())
                .build();

        educationDetailsRepo.save(educationDetails1);

        return RegistrationResponse.builder().code(201).message("Details Updated For the User").build();

    }
}
