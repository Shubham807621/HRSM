package com.hrsm.HRSM.service;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.PersonalInfo;
import com.hrsm.HRSM.repo.EmployeeRepo;
import com.hrsm.HRSM.repo.PersonalInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoService {

    @Autowired
    private PersonalInfoRepo personalInfoRepo;

    @Autowired
    private EmployeeRepo employeeRepo;


    public RegistrationResponse addDetails(String empId, PersonalInfo personalInfo) {
        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null){

            return RegistrationResponse.builder().code(401).message("User Not Found").build();
        }

        PersonalInfo personalInfo1 = PersonalInfo.builder()
                .employee(employee)
                .passportNo(personalInfo.getPassportNo())
                .passportExpiryDate(personalInfo.getPassportExpiryDate())
                .nationality(personalInfo.getNationality())
                .maritalStatus(personalInfo.getMaritalStatus())
                .noOfChildren(personalInfo.getNoOfChildren())
                .build();
        personalInfoRepo.save(personalInfo1);
        return RegistrationResponse.builder().code(201).message("Details Added").build();
    }

    public RegistrationResponse updateDetails(String empId, PersonalInfo personalInfo) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null){

            return RegistrationResponse.builder().code(401).message("User Not Found").build();
        }

        PersonalInfo personalInfo1 = PersonalInfo.builder()
                .employee(employee)
                .passportNo(personalInfo.getPassportNo())
                .passportExpiryDate(personalInfo.getPassportExpiryDate())
                .nationality(personalInfo.getNationality())
                .maritalStatus(personalInfo.getMaritalStatus())
                .noOfChildren(personalInfo.getNoOfChildren())
                .build();
        personalInfoRepo.save(personalInfo1);
        return RegistrationResponse.builder().code(201).message("Details Updated").build();
    }
}
