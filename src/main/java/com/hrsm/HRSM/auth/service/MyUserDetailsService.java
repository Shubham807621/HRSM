package com.hrsm.HRSM.auth.service;

import com.hrsm.HRSM.auth.entity.Users;
import com.hrsm.HRSM.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByEmail(username);

        if(user == null){
            throw new UsernameNotFoundException("User not Found"+ username);

        }
        return user;
    }
}
