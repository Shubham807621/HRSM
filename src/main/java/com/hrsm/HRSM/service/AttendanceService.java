package com.hrsm.HRSM.service;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Attendance;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.repo.AttendanceRepo;
import com.hrsm.HRSM.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepo attendanceRepo;

    @Autowired
    private EmployeeRepo employeeRepo;


    public RegistrationResponse punchIn(String empId) {
        Employee employee = employeeRepo.findByEmpId(empId);
        if (employee == null) {
            return RegistrationResponse.builder().code(400).message("User Not Found").build();
        }

        Attendance attendance = Attendance.builder()
                .employee(employee) // ✅ Link to Employee
                .punchIn(LocalDateTime.now())
                .present(true)
                .build();

        attendanceRepo.save(attendance);
        return RegistrationResponse.builder().code(200).message(String.valueOf(LocalDateTime.now())).build();
    }


    public Attendance punchOut(String empId) {
        // 1️⃣ Find Employee by empId
        Employee employee = employeeRepo.findByEmpId(empId);

        if (employee == null) {
            throw new RuntimeException("Employee not found!");
        }

        // 2️⃣ Get the latest attendance record where punchOut is NULL
        Optional<Attendance> attendanceOpt = attendanceRepo.findLatestAttendanceByEmployee(employee);
        if (attendanceOpt.isEmpty()) {
            throw new RuntimeException("No active punch-in record found for the employee.");
        }

        Attendance attendance = attendanceOpt.get();

        // 3️⃣ Update punchOut time
        LocalDateTime punchOutTime = LocalDateTime.now();
        attendance.setPunchOut(punchOutTime);

        // 4️⃣ Calculate total hours worked
        Duration duration = Duration.between(attendance.getPunchIn(), punchOutTime);
        attendance.setTotalHours((double) duration.toMinutes() / 60); // Convert minutes to hours

        // 5️⃣ Save updated attendance record
        return attendanceRepo.save(attendance);
    }
}
