package com.backend.service;

import com.backend.model.Account;
import com.backend.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    IAccountRepo iAccountRepo;

    public List<Account> getAll() {
        return (List<Account>) iAccountRepo.findAll();
    }

    public Account save(Account account) {
        return iAccountRepo.save(account);
    }

    public void delete(long id) {
        iAccountRepo.deleteById(id);
    }
}
