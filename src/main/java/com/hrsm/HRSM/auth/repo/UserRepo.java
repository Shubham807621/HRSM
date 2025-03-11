package com.hrsm.HRSM.auth.repo;

import com.hrsm.HRSM.auth.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<Users, UUID> {

    Users findByEmail(String username);
}
