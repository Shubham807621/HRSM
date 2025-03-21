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
@Table(name = "basic_info")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasicInfo {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    private int phoneNumber;

    private String gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private String address;


}
