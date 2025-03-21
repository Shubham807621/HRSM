package com.hrsm.HRSM.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "attendance")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendance {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id", columnDefinition = "BINARY(16)")
    @JsonIgnore
    private Employee employee;

    @Column(nullable = false)
    private LocalDateTime  punchIn;

    @Column(nullable = true)
    private LocalDateTime punchOut;

    @Column(nullable = true)
    private Double totalHours;

    @Column(nullable = false)
    private boolean present;

}