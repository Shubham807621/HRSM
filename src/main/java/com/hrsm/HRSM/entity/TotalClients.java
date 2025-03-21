package com.hrsm.HRSM.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="total_clients")
public class TotalClients {
    @Id
    @GeneratedValue
    private UUID id;

    private String companyName;


}