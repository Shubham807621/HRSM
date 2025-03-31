package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.entity.BasicInfo;
import com.hrsm.HRSM.entity.Task;
import com.hrsm.HRSM.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable String empId) {
        List<Task> task1 = service.getAllTasks(empId);

        return new ResponseEntity<>(task1, HttpStatus.OK);
    }


    @PostMapping("/{empId}")
    public ResponseEntity<Task> createTask(@PathVariable String empId, @RequestBody Task task){
        Task task1 = service.createTask(empId, task);

        return new ResponseEntity<>(task1, HttpStatus.CREATED);
    }
}