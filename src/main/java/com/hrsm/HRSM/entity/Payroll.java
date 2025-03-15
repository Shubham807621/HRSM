package com.hrsm.HRSM.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "payroll")
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @Column(nullable = false)
    private double basicSalary;

    @Column(nullable = false)
    private double allowances;

    @Column(nullable = false)
    private double deductions;

    @Column(nullable = false)
    private double netSalary;

    @Column(nullable = false)
    private LocalDate paymentDate;

}

