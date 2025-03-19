package com.hrsm.HRSM.repo;


import com.hrsm.HRSM.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepo extends JpaRepository<Experience, Long> {
}
