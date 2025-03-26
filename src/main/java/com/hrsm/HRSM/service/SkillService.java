package com.hrsm.HRSM.service;

import com.hrsm.HRSM.entity.Skill;
import com.hrsm.HRSM.repo.SkillsRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SkillService {

    private final SkillsRepo skillRepository;

    public SkillService(SkillsRepo skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
}


}