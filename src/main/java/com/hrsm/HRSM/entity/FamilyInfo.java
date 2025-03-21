package com.hrsm.HRSM.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "family_info")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FamilyInfo {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @Column(name = "name")
    private String Name;

    @Column(name = "relationship")
    private String relationship;

    private Date DOB;

    private int phoneNumber;
}
