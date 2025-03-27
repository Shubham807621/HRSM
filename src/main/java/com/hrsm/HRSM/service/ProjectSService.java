package com.hrsm.HRSM.service;


import com.hrsm.HRSM.dto.CountDetails;
import com.hrsm.HRSM.entity.Projects;
import com.hrsm.HRSM.entity.TotalClients;
import com.hrsm.HRSM.repo.ProjectRepo;
import com.hrsm.HRSM.repo.TotalClientSRepo;
import com.hrsm.HRSM.repo.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectSService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private TotalClientSRepo totalClientSRepo;

    @Autowired
    private TrainingRepository trainingRepository;

    public Long GetProjects() {
        return projectRepo.count();
    }

    public Projects createProject(Projects projects) {

        return projectRepo.save(projects);
    }

    public CountDetails getCounts() {
       Long projectCount = projectRepo.count();
       Long clientCount = totalClientSRepo.count();
       Long trainingCount= trainingRepository.count();
       return CountDetails.builder()
               .totalClientCount(clientCount)
               .totalProjectCount(projectCount)
               .totalTrainingCount(trainingCount)
               .build();

    }
}
