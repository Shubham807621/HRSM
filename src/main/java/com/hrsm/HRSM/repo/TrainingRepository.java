package com.hrsm.HRSM.repo;


import com.hrsm.HRSM.entity.Training;
import com.hrsm.HRSM.service.TrainingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrainingRepository extends JpaRepository<Training, UUID> {
    Training findByTitle(String title);
}
