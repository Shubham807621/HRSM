package com.hrsm.HRSM.repo;


import com.hrsm.HRSM.dto.LeaveCountDto;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LeaveRepo extends JpaRepository<LeaveRequest, UUID> {
    LeaveRequest findByEmployee(Employee employee);

    LeaveRequest findByEmployeeId(UUID id);

    @Query("SELECT new com.hrsm.HRSM.dto.LeaveCountDto(" +
            "SUM(CASE WHEN lr.leaveType = 'Causal Leave' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN lr.leaveType = 'Sick Leave' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN lr.leaveType = 'Earned Leave' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN lr.leaveType = 'Planned Leave' THEN 1 ELSE 0 END), " +
            "SUM(CASE WHEN lr.leaveType = 'Flexi Leave' THEN 1 ELSE 0 END)) " +
            "FROM LeaveRequest lr WHERE lr.employee.id = :employeeId")
    LeaveCountDto countLeaveRequestsByType(@org.springframework.data.repository.query.Param("employeeId") UUID employeeId);

}
