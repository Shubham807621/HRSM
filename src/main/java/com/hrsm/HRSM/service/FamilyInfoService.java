package com.hrsm.HRSM.service;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.FamilyInfo;
import com.hrsm.HRSM.repo.EmployeeRepo;
import com.hrsm.HRSM.repo.FamilyInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyInfoService {

    @Autowired
    private FamilyInfoRepo familyInfoRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public RegistrationResponse createFamilyInfo(FamilyInfo familyInfo, String empId) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null){

            return RegistrationResponse.builder().code(400).message("User Not Found").build();
        }

        FamilyInfo familyInfo1 = FamilyInfo.builder()
                                .employee(employee)
                                .Name(familyInfo.getName())
                                .relationship(familyInfo.getRelationship())
                                .phoneNumber(familyInfo.getPhoneNumber())
                                .DOB(familyInfo.getDOB())
                                .build();

        familyInfoRepo.save(familyInfo1);
        return RegistrationResponse.builder().code(201).message("Family Details has been Added").build();

    }
}
