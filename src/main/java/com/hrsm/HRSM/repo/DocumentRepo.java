package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentRepo extends JpaRepository<Document, UUID> {
}
