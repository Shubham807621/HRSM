package com.hrsm.HRSM.service;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.auth.service.EmailService;
import com.hrsm.HRSM.dto.SupportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportService {

    @Autowired
    private EmailService emailService;


    public RegistrationResponse sendReport(SupportDto supportDto) {

        return emailService.sendReportMail(supportDto);
    }
}
