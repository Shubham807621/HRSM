package com.hrsm.HRSM.controller;

import com.hrsm.HRSM.entity.TotalClients;
import com.hrsm.HRSM.service.TotalClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "http://localhost:5173")
public class TotalClientController {

    @Autowired
    private TotalClientsService totalClientsService;

    @GetMapping
    public ResponseEntity<Long> GetTotalClient()
    {
        Long count = totalClientsService.GetTotalClient();
        return new ResponseEntity<>(count, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<TotalClients> create(@RequestBody TotalClients totalClients)
    {
        TotalClients totalClients1 = totalClientsService.createClient(totalClients);
        return new ResponseEntity<>(totalClients1, HttpStatus.CREATED);
    }

}
