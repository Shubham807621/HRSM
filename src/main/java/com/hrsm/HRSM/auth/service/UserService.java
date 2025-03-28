package com.hrsm.HRSM.auth.service;

import com.hrsm.HRSM.auth.dto.*;
import com.hrsm.HRSM.auth.entity.Authority;
import com.hrsm.HRSM.auth.entity.Users;
import com.hrsm.HRSM.auth.helper.VerificationCode;
import com.hrsm.HRSM.auth.repo.UserRepo;
import com.hrsm.HRSM.dto.EmployeeDto;
import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.service.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private EmployeeServiceImp employeeService;

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

        String EmpName = request.getFirstName() + " " + request.getLastName();

        EmployeeDto employeeDto = EmployeeDto.builder()
                .name(EmpName)
                .email(request.getEmail())
                .phoneNumber(Integer.valueOf(request.getPhoneNumber()))
                .build();
             employeeService.addEmployee(employeeDto);

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

    public UserDetailsDto getProfile(String username) {

        Users users = userRepo.findByEmail(username);

        if (users == null) {
            throw new RuntimeException("User not found with email: " + username);
        }
        System.out.println(users);
       return UserDetailsDto.builder()
                .firstName(users.getFirstName())
                .lastName(users.getLastName())
                .email(users.getEmail())
                .id(users.getId())
                .phoneNumber(users.getPhoneNumber())
                .authorityList(users.getAuthorities().toArray()).build();
    }

    public List<UserRoleDetails> getUsers() {

        List<Users> users = userRepo.findAll();
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    private UserRoleDetails toDto(Users users) {
        String userName = users.getFirstName()+" "+users.getLastName();
        String roleCode = users.getAuthorities().stream()
                .filter(auth -> auth instanceof Authority) // Ensure it's Authority type
                .map(auth -> ((Authority) auth).getRoleCode()) // Cast to Authority and get roleCode
                .collect(Collectors.joining(", ")); // Join multiple roles with comma if needed

        return UserRoleDetails.builder()
                .userName(users.getEmail())
                .name(userName)
                .roleCode(roleCode)  // Set roleCode
                .build();
    }
}
