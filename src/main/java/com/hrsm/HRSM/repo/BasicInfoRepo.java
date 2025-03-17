package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInfoRepo extends JpaRepository<BasicInfo, Long> {
}
