package com.backend.service;

import com.backend.model.BillStatus;
import com.backend.repo.IBillStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillStatusService {
    @Autowired
    IBillStatusRepo iBillStatusRepo;
    public BillStatus findBillStatusById(Long id) {
        return iBillStatusRepo.findById(id).get();
    }
}
