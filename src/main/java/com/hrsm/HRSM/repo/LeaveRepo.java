package com.hrsm.HRSM.repo;


import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LeaveRepo extends JpaRepository<LeaveRequest, UUID> {
    LeaveRequest findByEmployee(Employee employee);

}
