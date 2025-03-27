package com.hrsm.HRSM.controller;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.dto.AttendanceDto;
import com.hrsm.HRSM.entity.Attendance;
import com.hrsm.HRSM.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "http://localhost:5173")
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


    @GetMapping("/attendance-list")
    public ResponseEntity<List<AttendanceDto>> getAllAttendance(){

        List<AttendanceDto> attendance = attendanceService.getAllAttendance();

        return new ResponseEntity<>(attendance, HttpStatus.OK);
    }

    @GetMapping("/attendance-list/{empId}")
    public ResponseEntity<List<Attendance>> getAllAttendance(@PathVariable String empId){

        List<Attendance> attendance = attendanceService.getAllAttendanceById(empId);

        return new ResponseEntity<>(attendance, HttpStatus.OK);
    }



}
