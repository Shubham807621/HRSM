package com.hrsm.HRSM.auth.service;

import com.hrsm.HRSM.auth.dto.LoginRequest;
import com.hrsm.HRSM.auth.dto.RegistrationRequest;
import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.auth.entity.Users;
import com.hrsm.HRSM.auth.helper.VerificationCode;
import com.hrsm.HRSM.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private EmailService emailService;

    public RegistrationResponse register(RegistrationRequest request){

        Users existing =userRepo.findByEmail(request.getEmail());

        if(null != existing){
                return RegistrationResponse.builder()
                        .code(400)
                        .message("Email Already Exist !!")
                        .build();
        }

    try {

        Users user = new Users();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setEnabled(false);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());

        String code = VerificationCode.generateCode();

        user.setVerificationCode(code);
        user.setAuthorities(authorityService.getAuthorities());
        emailService.sendMail(user);
        userRepo.save(user);


        return RegistrationResponse.builder()
                .code(200)
                .message("User Account Created!!")
                .build();

    } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new ServerErrorException(e.getMessage(),e.getCause());
    }

    }

    public void verifyUser(String userName) {

        Users user = userRepo.findByEmail(userName);
        user.setEnabled(true);
        userRepo.save(user);
    }

    public RegistrationResponse updatePassword(LoginRequest loginRequest) {

        Users existing = userRepo.findByEmail(loginRequest.getUserName());
        if (null != existing) {

            existing.setPassword(passwordEncoder.encode(loginRequest.getPassword()));

            userRepo.save(existing);
            return RegistrationResponse.builder().code(200).message("Password updated").build();
        }
        return RegistrationResponse.builder().code(400).message("Error while updating password").build();

    }
}
