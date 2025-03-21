package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Attendance;
import com.hrsm.HRSM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AttendanceRepo extends JpaRepository<Attendance, UUID> {

    // Get latest attendance record where punchOut is NULL (Active punch-in)
    @Query("SELECT a FROM Attendance a WHERE a.employee = :employee AND a.punchOut IS NULL ORDER BY a.punchIn DESC")
    Optional<Attendance> findLatestAttendanceByEmployee(Employee employee);
}
