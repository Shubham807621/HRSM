package com.hrsm.HRSM.auth.repo;

import com.hrsm.HRSM.auth.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority, UUID> {
    Authority findByRoleCode(String user);
}
