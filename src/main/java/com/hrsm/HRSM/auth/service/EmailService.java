package com.hrsm.HRSM.auth.service;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.auth.entity.Users;
import com.hrsm.HRSM.dto.SupportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Value("${spring.mail.username}")
    private String sender;


    public String sendMail(Users user){

        String subject = "Verify your email";
        String senderName = "HRSM Company";
        String mailContent = "Hello " + user.getUsername() + ",\n";
        mailContent += "Your verification code is: " + user.getVerificationCode() + "\n";
        mailContent += "Please enter this code to verify your email.";
        mailContent +="\n";
        mailContent+= senderName;

        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(user.getEmail());
            mailMessage.setText(mailContent);
            mailMessage.setSubject(subject);
            javaMailSender.send(mailMessage);
        }
        catch (Exception e){
            return "Error while Sending Mail";
        }
        return "Email sent";

    }

    public RegistrationResponse sendReportMail(SupportDto supportDto) {


        String subject = supportDto.getSubjectLine();
        String senderName = supportDto.getName();
        String mailContent = supportDto.getMessage();
        String senderMail = supportDto.getEmail();
        mailContent+="\n";
        mailContent+="\n";
        mailContent+="Regards";
        mailContent+="\n";
        mailContent+=senderName;

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender); // Must match SMTP user
            mailMessage.setReplyTo(senderMail);  // Actual sender's email
            mailMessage.setTo(sender);
            mailMessage.setText(mailContent);
            mailMessage.setSubject(subject);
            javaMailSender.send(mailMessage);
        }  catch (Exception e){
            return RegistrationResponse.builder().code(400).message("Error while Sending Mail").build();
        }

        return  RegistrationResponse.builder().code(400).message("Email sent").build();
    }
}
