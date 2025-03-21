package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Training;
import com.hrsm.HRSM.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
@CrossOrigin("*")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;


    @GetMapping
    public ResponseEntity<List<Training>> getAllTraining(){

        List<Training> trainings = trainingService.getAllTraining();

        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistrationResponse> createTraining(@RequestBody Training training){

        RegistrationResponse registrationResponse = trainingService.createTraining(training);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<RegistrationResponse> updateTraining(@RequestBody Training training){
        RegistrationResponse registrationResponse= trainingService.updateTraining(training);
        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);
    }


}
