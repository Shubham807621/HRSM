package com.hrsm.HRSM.repo;


import com.hrsm.HRSM.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillsRepo extends JpaRepository<Skill, UUID> {
}
