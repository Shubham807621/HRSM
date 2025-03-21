package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepo extends JpaRepository<Projects , UUID> {
}
