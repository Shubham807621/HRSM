package com.hrsm.HRSM.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "family_info")
@AllArgsConstructor
@NoArgsConstructor
public class FamilyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @Column(name = "spouse_name")
    private String spouseName;

    @Column(name = "no_of_dependents")
    private int noOfDependents;

}
