package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.BankInfo;
import com.hrsm.HRSM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankInfoRepo extends JpaRepository<BankInfo , UUID> {
    BankInfo findByEmployee(Employee employee);
}
