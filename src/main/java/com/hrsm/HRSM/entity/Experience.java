package com.hrsm.HRSM.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "experience")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Experience {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "role")
    private String role;

    @Column(name = "duration")
    private String duration;

}
