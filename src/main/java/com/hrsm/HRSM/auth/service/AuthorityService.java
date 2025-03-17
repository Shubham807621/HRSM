package com.hrsm.HRSM.auth.service;

import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.auth.dto.UpdateRoleDTo;
import com.hrsm.HRSM.auth.entity.Authority;
import com.hrsm.HRSM.auth.entity.Users;
import com.hrsm.HRSM.auth.repo.AuthorityRepo;
import com.hrsm.HRSM.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepo authorityRepo;


    @Autowired
    private UserRepo userRepo;

    public List<Authority> getAuthorities(){
        List<Authority> authorities =new ArrayList<>();
        Authority authority= authorityRepo.findByRoleCode("Employee");
        authorities.add(authority);
        return  authorities;

    }

    public Authority createAuthority(Authority authority) {
        Authority authority1= Authority.builder().roleCode(authority.getRoleCode()).roleDescription(authority.getRoleDescription()).build();
        return authorityRepo.save(authority);
    }

    public RegistrationResponse updateRole(UpdateRoleDTo updateRoleDTo) {

        Users users = userRepo.findByEmail(updateRoleDTo.getUserName());
        if (users == null) {
            return RegistrationResponse.builder()
                    .code(404)
                    .message("User not found")
                    .build();
        }

        // Fetch the role from the database using roleCode
        Authority authority = authorityRepo.findByRoleCode(updateRoleDTo.getRoleCode());

        if (authority == null) {
            return RegistrationResponse.builder()
                    .code(400)
                    .message("Invalid role code")
                    .build();
        }

        // Assign the new role to the user
        List<Authority> newAuthorities = new ArrayList<>();
        newAuthorities.add(authority);

        users.setAuthorities(newAuthorities);

        userRepo.save(users);

        return RegistrationResponse.builder()
                .code(200)
                .message("Role updated successfully")
                .build();
    }

}
