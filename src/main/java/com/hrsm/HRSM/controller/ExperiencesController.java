package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.EducationDetails;
import com.hrsm.HRSM.entity.Experience;
import com.hrsm.HRSM.service.ExperiencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin(origins = "http://localhost:5173")
public class ExperiencesController {

    @Autowired
    private ExperiencesService experiencesService;


    @PostMapping("/{empId}")
    public ResponseEntity<Experience> addExperience(@PathVariable String empId, @RequestBody Experience experience){

        Experience experience1 = experiencesService.addExperience(empId,experience);

        return new ResponseEntity<>(experience1, HttpStatus.CREATED);
    }

    @PutMapping("/{empId}")
    public ResponseEntity<RegistrationResponse> updateExperience(@PathVariable String empId, @RequestBody Experience experience){

        RegistrationResponse registrationResponse = experiencesService.updateDetails(empId, experience);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);

    }


}
