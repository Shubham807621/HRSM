package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.FamilyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FamilyInfoRepo extends JpaRepository<FamilyInfo, UUID> {
    FamilyInfo findByEmployee(Employee employee);
}
