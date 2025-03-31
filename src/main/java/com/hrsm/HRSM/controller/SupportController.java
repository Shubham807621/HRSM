package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.dto.SupportDto;
import com.hrsm.HRSM.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SupportController {

    @Autowired
    private SupportService supportService;

    @PostMapping("/support/report")
    public ResponseEntity<RegistrationResponse> getReport(@RequestBody SupportDto supportDto){
        RegistrationResponse registrationResponse = supportService.sendReport(supportDto);

        return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
    }
}
