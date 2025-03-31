package com.hrsm.HRSM.controller;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.dto.LeaveCountDto;
import com.hrsm.HRSM.dto.LeaveRequestDto;
import com.hrsm.HRSM.entity.LeaveRequest;
import com.hrsm.HRSM.entity.LeaveStatus;
import com.hrsm.HRSM.service.LeaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/leave")
@CrossOrigin(origins = "*")
public class LeaveController {


    @Autowired
    private LeaverService leaverService;


    @GetMapping
    public ResponseEntity<List<LeaveRequestDto>> getAll(){
        List<LeaveRequestDto> leaveRequests = leaverService.getALl();

        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<List<LeaveRequest>> getAllLeave(@PathVariable String empId){

        List<LeaveRequest> leaveRequests = leaverService.getAllLeaves(empId);

        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
    }

    @PostMapping("/add/{empId}")
    public ResponseEntity<LeaveRequest> create(@RequestBody LeaveRequest leaveRequest, @PathVariable String empId)
    {
        LeaveRequest leaveRequest1 =leaverService.create(leaveRequest, empId);

        return new ResponseEntity<>(leaveRequest1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{empId}/{id}/status")
    public ResponseEntity<LeaveRequest> updateLeaveByID(@PathVariable String empId, @PathVariable UUID id, @RequestBody LeaveStatus status){

        LeaveRequest leaveRequests = leaverService.updateLeaveByID(empId,id, status);

        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
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
