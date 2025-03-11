package com.hrsm.HRSM.auth.service;

import com.hrsm.HRSM.auth.entity.Authority;
import com.hrsm.HRSM.auth.repo.AuthorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepo authorityRepo;

    public List<Authority> getAuthorities(){
        List<Authority> authorities =new ArrayList<>();
        Authority authority= authorityRepo.findByRoleCode("USER");
        authorities.add(authority);
        return  authorities;

    }
}
