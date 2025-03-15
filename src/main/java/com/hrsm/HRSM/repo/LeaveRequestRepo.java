package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Long> {
}
