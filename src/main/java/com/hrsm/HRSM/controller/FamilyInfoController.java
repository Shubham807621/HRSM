package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Experience;
import com.hrsm.HRSM.entity.FamilyInfo;
import com.hrsm.HRSM.service.FamilyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/family-info")
public class FamilyInfoController {


    @Autowired
    private FamilyInfoService familyInfoService;


    @PostMapping("/{empId}")
    public ResponseEntity<RegistrationResponse> createFamilyInfo(@RequestBody FamilyInfo familyInfo , @PathVariable String empId){

        RegistrationResponse registrationResponse = familyInfoService.createFamilyInfo(familyInfo, empId);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);

    }
    @PutMapping("/{empId}")
    public ResponseEntity<RegistrationResponse> updateFamilyInfo(@RequestBody FamilyInfo familyInfo , @PathVariable String empId){

        RegistrationResponse registrationResponse = familyInfoService.updateFamilyInfo(empId, familyInfo);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);

    }
}
