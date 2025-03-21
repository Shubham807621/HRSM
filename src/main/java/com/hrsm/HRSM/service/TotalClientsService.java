package com.hrsm.HRSM.service;


import com.hrsm.HRSM.entity.TotalClients;
import com.hrsm.HRSM.repo.TotalClientSRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalClientsService {

    @Autowired
    private TotalClientSRepo totalClientSRepo;

    public TotalClients createClient(TotalClients totalClients) {

        return totalClientSRepo.save(totalClients);
    }


    public Long GetTotalClient() {
        return totalClientSRepo.count();
    }
}
