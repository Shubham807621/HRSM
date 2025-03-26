package com.hrsm.HRSM.controller;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.dto.LeaveCountDto;
import com.hrsm.HRSM.entity.LeaveRequest;
import com.hrsm.HRSM.service.LeaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave")
@CrossOrigin(origins = "http://localhost:5173")
public class LeaveController {


    @Autowired
    private LeaverService leaverService;


    @PostMapping("/add/{empId}")
    public ResponseEntity<LeaveRequest> create(@RequestBody LeaveRequest leaveRequest, @PathVariable String empId)
    {
        LeaveRequest leaveRequest1 =leaverService.create(leaveRequest, empId);

        return new ResponseEntity<>(leaveRequest1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<RegistrationResponse> deleteLeave(@PathVariable String empId)
    {
        RegistrationResponse registrationResponse = leaverService.deleteLeave(empId);

        return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
    }

    @GetMapping("/leave_count/{empId}")
    public ResponseEntity<LeaveCountDto> getLeaveCounts(@PathVariable String empId) {
        LeaveCountDto leaveCountDto = leaverService.getLeaveCounts(empId);
        return new ResponseEntity<>(leaveCountDto, HttpStatus.OK);
    }


}
