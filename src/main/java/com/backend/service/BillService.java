package com.backend.service;

import com.backend.model.Account;
import com.backend.model.Bill;
import com.backend.repo.IAccRepo;
import com.backend.repo.IBillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    IBillRepo iBillRepo;
    @Autowired
    IAccRepo iAccRepo;
    public void saveBill(Bill bill) {
        iBillRepo.save(bill);
    }
    public List<Bill> getAllBillByAccount(String username) {
        Account account = iAccRepo.findAccountByUserName(username);
        return iBillRepo.findAllByAccount(account);
    }
}
