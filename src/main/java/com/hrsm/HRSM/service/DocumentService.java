package com.hrsm.HRSM.service;


import com.hrsm.HRSM.auth.dto.RegistrationResponse;
import com.hrsm.HRSM.entity.Document;
import com.hrsm.HRSM.repo.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepo documentRepo;

    public Document createDocument(Document document) {
        return documentRepo.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentRepo.findAll();
    }

    public RegistrationResponse deleteDocument(UUID id) {

        documentRepo.findById(id);
        return RegistrationResponse.builder()
                .code(200)
                .message("Document Has Been Deleted")
                .build();
    }
}

