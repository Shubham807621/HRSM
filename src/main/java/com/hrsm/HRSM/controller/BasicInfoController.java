package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.BankInfo;
import com.hrsm.HRSM.entity.BasicInfo;
import com.hrsm.HRSM.repo.EmployeeRepo;
import com.hrsm.HRSM.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/basic-info")
@CrossOrigin(origins = "http://localhost:5173")
public class BasicInfoController {


    @Autowired
    private BasicInfoService basicInfoService;



    @PostMapping("/{empId}")
    public ResponseEntity<BasicInfo> createBasicInfo(@PathVariable String empId, @RequestBody BasicInfo basicInfo){
        BasicInfo basicInfo1 = basicInfoService.createBasicInfo(empId, basicInfo);

        return new ResponseEntity<>(basicInfo1, HttpStatus.CREATED);
    }

    @PutMapping("/{empId}")
    public  ResponseEntity<RegistrationResponse> updateBasicInfo(@RequestBody BasicInfo basicInfo, @PathVariable String empId){

        RegistrationResponse registrationResponse = basicInfoService.updateBasicInfo(basicInfo, empId);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);
    }


}
