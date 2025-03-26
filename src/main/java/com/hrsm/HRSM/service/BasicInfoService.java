package com.hrsm.HRSM.service;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.BasicInfo;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.repo.BasicInfoRepo;
import com.hrsm.HRSM.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicInfoService {


    @Autowired
    private BasicInfoRepo basicInfoRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public BasicInfo createBasicInfo(String empId, BasicInfo basicInfo) {

        Employee employee = employeeRepo.findByEmpId(empId);

        BasicInfo basicInfo1 = BasicInfo.builder()
                               .employee(employee)
                               .address(basicInfo.getAddress())
                               .phoneNumber(basicInfo.getPhoneNumber())
                               .gender(basicInfo.getGender())
                               .dateOfBirth(basicInfo.getDateOfBirth())
                               .build();

        return basicInfoRepo.save(basicInfo1);
    }

    public RegistrationResponse updateBasicInfo(BasicInfo basicInfo, String empId) {

        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null) {
//            throw new RuntimeException("Employee not found with empId: " + empId);
            return RegistrationResponse.builder()
                    .code(400)
                    .message("Employee not found")
                    .build();
        }

        BasicInfo basicInfo1 = basicInfoRepo.findByEmployee(employee);

        if (basicInfo1 !=null){

            basicInfo1.setAddress(basicInfo.getAddress());
            basicInfo1.setPhoneNumber(basicInfo.getPhoneNumber());
            basicInfo1.setGender(basicInfo.getGender());
            basicInfo1.setDateOfBirth(basicInfo.getDateOfBirth());

            basicInfoRepo.save(basicInfo1);
        }
        else {
            BasicInfo basicInfo2 = BasicInfo.builder()
                    .employee(employee)
                    .address(basicInfo.getAddress())
                    .phoneNumber(basicInfo.getPhoneNumber())
                    .gender(basicInfo.getGender())
                    .dateOfBirth(basicInfo.getDateOfBirth())
                    .build();

            basicInfoRepo.save(basicInfo2);
        }

        return RegistrationResponse.builder()
                .code(201)
                .message("Details Updated")
                .build();


    }
}
