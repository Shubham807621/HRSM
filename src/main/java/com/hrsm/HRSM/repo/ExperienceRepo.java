package com.hrsm.HRSM.repo;


import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExperienceRepo extends JpaRepository<Experience, UUID> {
    Experience findByEmployee(Employee employee);
}
