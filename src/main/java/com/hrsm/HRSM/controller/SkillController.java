package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.entity.Skill;
import com.hrsm.HRSM.entity.Task;
import com.hrsm.HRSM.service.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend requests
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills(@PathVariable String empId) {
        List<Skill> skills = skillService.getAllSkills(empId);

        return new ResponseEntity<>(skills, HttpStatus.OK);
    }


    @PostMapping("/{empId}")
    public ResponseEntity<Skill> createSkill(@PathVariable String empId, @RequestBody Skill skill){
        Skill skil1 = skillService.createSkill(empId, skill);

        return new ResponseEntity<>(skil1, HttpStatus.CREATED);
    }
}