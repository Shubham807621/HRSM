package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.BankInfo;
import com.hrsm.HRSM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankInfoRepo extends JpaRepository<BankInfo ,Long> {
    BankInfo findByEmployee(Employee employee);
}
