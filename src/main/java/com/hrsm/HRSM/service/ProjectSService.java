package com.hrsm.HRSM.service;


import com.hrsm.HRSM.entity.Projects;
import com.hrsm.HRSM.entity.TotalClients;
import com.hrsm.HRSM.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectSService {

    @Autowired
    private ProjectRepo projectRepo;

    public Long GetProjects() {
        return projectRepo.count();
    }

    public Projects createProject(Projects projects) {

        return projectRepo.save(projects);
    }
}
