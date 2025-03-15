package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
}
