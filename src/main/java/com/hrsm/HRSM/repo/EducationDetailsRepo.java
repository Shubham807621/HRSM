package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.EducationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EducationDetailsRepo extends JpaRepository<EducationDetails, UUID> {
}
