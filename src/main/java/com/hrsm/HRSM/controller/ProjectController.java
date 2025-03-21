package com.hrsm.HRSM.controller;


import com.hrsm.HRSM.entity.Projects;
import com.hrsm.HRSM.entity.TotalClients;
import com.hrsm.HRSM.service.ProjectSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectSService projectSService;


    @GetMapping
    public ResponseEntity<Long> GetProjects()
    {
        Long count = projectSService.GetProjects();
        return new ResponseEntity<>(count, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Projects> create(@RequestBody Projects projects)
    {
        Projects projects1 = projectSService.createProject(projects);
        return new ResponseEntity<>(projects1, HttpStatus.CREATED);
    }
}
