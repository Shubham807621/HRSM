package com.hrsm.HRSM.service;

import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.Skill;
import com.hrsm.HRSM.repo.EmployeeRepo;
import com.hrsm.HRSM.repo.SkillsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private EmployeeRepo employeeRepo;

    private final SkillsRepo skillRepository;

    public SkillService(SkillsRepo skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getAllSkills(String empId) {
        Employee employee = employeeRepo.findByEmpId(empId);

        return skillRepository.findAllByEmployeeId(employee.getId());
}


    public Skill createSkill(String empId, Skill skill) {

        Employee employee = employeeRepo.findByEmpId(empId);

        Skill skill1 = Skill.builder()
                .employee(employee)
                .name(skill.getName())
                .color(skill.getColor())
                .percentage(skill.getPercentage())
                .updatedDate(skill.getUpdatedDate())
                .build();

       return skillRepository.save(skill1);
    }
}