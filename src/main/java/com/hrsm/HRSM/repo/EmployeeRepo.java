package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
