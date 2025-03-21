package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, UUID> {
}
