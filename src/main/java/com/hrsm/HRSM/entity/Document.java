package com.hrsm.HRSM.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "documents")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Document {

    @Id
    @GeneratedValue
    private UUID id;

    private String fileName;
    private String documentType;
    private String role;
    private String description;
//    private String filePath;

}
