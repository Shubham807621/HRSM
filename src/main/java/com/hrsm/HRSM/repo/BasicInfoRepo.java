package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BasicInfoRepo extends JpaRepository<BasicInfo, UUID> {
}
