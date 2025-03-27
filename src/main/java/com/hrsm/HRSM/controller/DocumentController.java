package com.hrsm.HRSM.controller;


import com.hrsm.HRSM.auth.dto.RegistrationRequest;
import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Document;
import com.hrsm.HRSM.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody Document document){

        Document document1 = documentService.createDocument(document);
        return new ResponseEntity<>(document1, HttpStatus.CREATED);
    }

    @GetMapping("/get-documents")
    public ResponseEntity<List<Document>> getAllDocument(){
        List<Document> documents = documentService.getAllDocuments();

        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegistrationResponse> deleteDocument(@PathVariable UUID id){
        RegistrationResponse registrationResponse =  documentService.deleteDocument(id);
        return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
    }

}
