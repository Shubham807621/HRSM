package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PayrollRepo extends JpaRepository<Payroll, UUID> {
}
