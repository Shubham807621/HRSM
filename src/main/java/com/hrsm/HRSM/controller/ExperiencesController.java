package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.entity.Experience;
import com.hrsm.HRSM.service.ExperiencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin("*")
public class ExperiencesController {

    @Autowired
    private ExperiencesService experiencesService;


    @PostMapping("/{empId}")
    public ResponseEntity<Experience> addExperience(@PathVariable String empId, @RequestBody Experience experience){

        Experience experience1 = experiencesService.addExperience(empId,experience);

        return new ResponseEntity<>(experience1, HttpStatus.CREATED);
    }


}
