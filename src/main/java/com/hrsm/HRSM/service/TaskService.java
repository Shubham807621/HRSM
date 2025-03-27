package com.hrsm.HRSM.service;

import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.entity.Task;
import com.hrsm.HRSM.repo.EmployeeRepo;
import com.hrsm.HRSM.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepo repository;

    @Autowired
    private EmployeeRepo employeeRepo;

    public TaskService(TaskRepo repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks(String empId) {

        Employee employee = employeeRepo.findByEmpId(empId);

        return repository.findAllByEmployeeId(employee.getId());

    }
    public Task createTask(String empId, Task task) {


        Employee employee = employeeRepo.findByEmpId(empId);

        Task task1 = Task.builder()
                .employee(employee)
                .name(task.getName())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .build();
        return repository.save(task1);
    }
}