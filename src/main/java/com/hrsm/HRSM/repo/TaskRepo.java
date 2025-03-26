package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepo extends JpaRepository<Task,UUID>{
}