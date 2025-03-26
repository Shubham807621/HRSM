package com.hrsm.HRSM.service;

import com.hrsm.HRSM.entity.Task;
import com.hrsm.HRSM.repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo repository;

    public TaskService(TaskRepo repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }
}