package com.hrsm.HRSM.controller;


import com.hrsm.HRSM.auth.dto.RegistrationRequest;
import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.BankInfo;
import com.hrsm.HRSM.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bank-info")
public class BankInfoController {


    @Autowired
    private BankInfoService bankInfoService;


    @PostMapping("/{empId}")
    public ResponseEntity<BankInfo> createBankInfo(@RequestBody BankInfo bankInfo , @PathVariable String empId){

        BankInfo bankInfo1 = bankInfoService.createBankInfo(bankInfo, empId);

        return new ResponseEntity<>(bankInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{empId}")
    public  ResponseEntity<RegistrationResponse> updateBankInfo(@RequestBody BankInfo bankInfo, @PathVariable String empId){

        RegistrationResponse registrationResponse = bankInfoService.updateBankInfo(bankInfo, empId);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);
    }
}
