package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.entity.BasicInfo;
import com.hrsm.HRSM.service.BasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/basic-info")
@CrossOrigin("*")
public class BasicInfoController {


    @Autowired
    private BasicInfoService basicInfoService;

    @PostMapping("/{empId}")
    public ResponseEntity<BasicInfo> createBasicInfo(@PathVariable String empId, @RequestBody BasicInfo basicInfo){
        BasicInfo basicInfo1 = basicInfoService.createBasicInfo(empId, basicInfo);

        return new ResponseEntity<>(basicInfo1, HttpStatus.CREATED);
    }


}
