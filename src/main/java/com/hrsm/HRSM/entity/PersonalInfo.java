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
@Table(name = "personal_info")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonalInfo {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    @Column(name = "passport_no")
    private String passportNo;

    @Column(name = "passport_expiry_date")
    private LocalDate passportExpiryDate;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "no_of_children")
    private int noOfChildren;

}
