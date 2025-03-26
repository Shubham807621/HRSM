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

    public RegistrationResponse updateFamilyInfo(String empId, FamilyInfo familyInfo) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null){
            return RegistrationResponse.builder().code(400).message("Employee Not  Found").build();

        }

        FamilyInfo familyInfo1 = familyInfoRepo.findByEmployee(employee);
        if (familyInfo1 != null){
            familyInfo1.setName(familyInfo.getName());
            familyInfo1.setRelationship(familyInfo.getRelationship());
            familyInfo1.setPhoneNumber(familyInfo.getPhoneNumber());
            familyInfo1.setDOB(familyInfo.getDOB());

            familyInfoRepo.save(familyInfo1);
        }
        else {
            FamilyInfo familyInfo2 = FamilyInfo.builder()
                    .employee(employee)
                    .Name(familyInfo.getName())
                    .relationship(familyInfo.getRelationship())
                    .phoneNumber(familyInfo.getPhoneNumber())
                    .DOB(familyInfo.getDOB())
                    .build();

            familyInfoRepo.save(familyInfo2);
        }
        return RegistrationResponse.builder().code(201).message("Family Details has been Added").build();
    }
}
