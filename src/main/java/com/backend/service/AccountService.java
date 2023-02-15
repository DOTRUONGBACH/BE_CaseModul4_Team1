package com.backend.service;

import com.backend.model.Account;
import com.backend.repo.IAccRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    IAccRepo iAccRepo;
    public List<Account> findALl(){
        return (List<Account>) iAccRepo.findAll();
    }
    public Account findByID(long id){
        return iAccRepo.findById(id).get();
    }
    public void save(Account account){
        iAccRepo.save(account);
    }
    public void delete(long id){
        iAccRepo.deleteById(id);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = iAccRepo.
//    }
}
