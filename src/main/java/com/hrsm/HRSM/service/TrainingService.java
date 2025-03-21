package com.hrsm.HRSM.service;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Training;
import com.hrsm.HRSM.repo.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public List<Training> getAllTraining() {
        return trainingRepository.findAll();
    }

    public RegistrationResponse createTraining(Training training) {

        Training training1 = trainingRepository.findByTitle(training.getTitle());
        if (training1 != null) {
            return RegistrationResponse.builder()
                .code(400)
                .message("Training Already Exist")
                .build();
        }

        trainingRepository.save(training);
        return RegistrationResponse.builder()
                .code(200)
                .message("Training Created")
                .build();

    }

    public RegistrationResponse updateTraining(Training training) {
        Training training1= trainingRepository.findByTitle(training.getTitle());
        if (training1 != null){
            trainingRepository.save(training1);
            return RegistrationResponse.builder().code(200).message("Training updated").build();
        }
        return RegistrationResponse.builder().code(400).message("Training not found").build();
    }
}
