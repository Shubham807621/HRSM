package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.TotalClients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TotalClientSRepo extends JpaRepository<TotalClients, UUID> {
}
