package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobPositionRepo extends JpaRepository<JobPosition, UUID> {
}
