package com.hrsm.HRSM.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "trainings")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Training {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String trainer;
    private LocalDate startDate;
    private LocalDate endDate;
    private String cost;
    private String status;

}
