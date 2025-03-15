package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
