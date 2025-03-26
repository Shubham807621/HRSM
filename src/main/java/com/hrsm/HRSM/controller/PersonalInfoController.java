package com.hrsm.HRSM.controller;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.PersonalInfo;
import com.hrsm.HRSM.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personal-info")
@CrossOrigin(origins = "http://localhost:5173")
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;


    @PostMapping("/{empId}")
    public ResponseEntity<RegistrationResponse> addDetails(@PathVariable String empId, @RequestBody PersonalInfo personalInfo){

        RegistrationResponse registrationResponse = personalInfoService.addDetails(empId, personalInfo);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);

    }

    @PutMapping("/{empId}")
    public ResponseEntity<RegistrationResponse> updateDetails(@PathVariable String empId, @RequestBody PersonalInfo personalInfo){

        RegistrationResponse registrationResponse = personalInfoService.updateDetails(empId, personalInfo);
        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);

    }
}
