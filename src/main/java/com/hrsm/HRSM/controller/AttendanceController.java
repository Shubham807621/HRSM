package com.hrsm.HRSM.controller;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Attendance;
import com.hrsm.HRSM.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin("*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Punch In API
    @PostMapping("/punch-in/{empId}")
    public ResponseEntity<RegistrationResponse> punchIn(@PathVariable String empId) {

        RegistrationResponse registrationResponse= attendanceService.punchIn(empId);

        return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
    }

    @PostMapping("/punch-out/{empId}")
    public ResponseEntity<Attendance> punchOut(@PathVariable String empId) {
        Attendance updatedAttendance = attendanceService.punchOut(empId);
        return ResponseEntity.ok(updatedAttendance);
    }




}
