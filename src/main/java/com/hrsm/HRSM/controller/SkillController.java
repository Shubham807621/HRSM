package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.entity.Skill;
import com.hrsm.HRSM.service.SkillService;
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
    public List<Skill> getSkills() {
        return skillService.getAllSkills();
    }
}