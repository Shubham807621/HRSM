package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.EducationDetails;
import com.hrsm.HRSM.service.EducationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/education")

public class EducationDetailsController {


    @Autowired
    private EducationDetailsService educationDetailsService;


    @PostMapping("/{empId}")
    public ResponseEntity<RegistrationResponse> createDetails(@PathVariable("empId")  String empId, @RequestBody EducationDetails educationDetails){

        RegistrationResponse registrationResponse = educationDetailsService.createDetails(empId, educationDetails);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);

    }

    @PutMapping("/{empId}")
    public ResponseEntity<RegistrationResponse> updateDetails(@PathVariable("empId")  String empId, @RequestBody EducationDetails educationDetails ){

        RegistrationResponse registrationResponse = educationDetailsService.updateDetails(empId, educationDetails);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);

    }
}
