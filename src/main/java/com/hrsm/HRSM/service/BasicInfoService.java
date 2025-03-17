package com.hrsm.HRSM.service;

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
}
