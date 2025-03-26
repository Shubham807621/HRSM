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
@Table(name = "skill")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Skill {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    private String name;
    private String color;
    private int percentage;
    private LocalDate updatedDate;
}