package com.hrsm.HRSM.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "leave_requests")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveRequest {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private String reason;

    @Enumerated(EnumType.STRING)
    private LeaveStatus status;


}