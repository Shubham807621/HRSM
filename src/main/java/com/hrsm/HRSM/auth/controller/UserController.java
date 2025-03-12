package com.hrsm.HRSM.auth.controller;


import com.hrsm.HRSM.auth.config.JWTTokenHelper;
import com.hrsm.HRSM.auth.dto.LoginRequest;
import com.hrsm.HRSM.auth.dto.RegistrationRequest;
import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.auth.dto.UserToken;
import com.hrsm.HRSM.auth.entity.Users;
import com.hrsm.HRSM.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTTokenHelper jwtTokenHelper;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest request){

        RegistrationResponse registrationResponse =  userService.register(request);

        return new ResponseEntity<>(registrationResponse,
                registrationResponse.getCode() == 200 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestBody Map<String,String> map){

        String userName = map.get("userName");
        String code = map.get("code");

        Users user = (Users) userDetailsService.loadUserByUsername(userName);

        System.out.println("Verification Code : "+user.getVerificationCode());

        if (null != user && user.getVerificationCode().equals(code)){
            userService.verifyUser(userName);
            return new ResponseEntity<>(Map.of("code", 200, "message", "Verification successful"), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@RequestBody LoginRequest loginRequest){
        try {
            Authentication authentication= UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.getUserName(),loginRequest.getPassword());

            Authentication authenticationResponse=this.authenticationManager.authenticate(authentication);

            if (authenticationResponse.isAuthenticated()){
                Users users= (Users) authenticationResponse.getPrincipal();

                if (!users.isEnabled()){
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }

                String Token= jwtTokenHelper.generateToken(users.getEmail());
                UserToken userToken = UserToken.builder().token(Token).build();
                return new ResponseEntity<>(userToken,HttpStatus.OK);
            }
        }
        catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

//    @PutMapping("/login")
//    public ResponseEntity<RegistrationResponse> updatePassword(@RequestBody LoginRequest loginRequest){
//
//        RegistrationResponse registrationResponse = userService.updatePassword(loginRequest);
//
//    }
}
