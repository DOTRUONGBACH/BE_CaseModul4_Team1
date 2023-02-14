package com.backend.service;

import com.backend.model.Account;
import com.backend.model.Role;
import com.backend.repo.IAccRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccRepo iAccRepo;

    public List<Account> getAll() {
        return (List<Account>) iAccRepo.findAll();
    }

    public Account save(Account account) {
        return iAccRepo.save(account);
    }

    public void delete(long id) {
        iAccRepo.deleteById(id);
    }

    public Account findAccountByUsername(String username) {
        return iAccRepo.findAccountByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccRepo.findAccountByUserName(username);
        List<Role> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUserName(), account.getPassWord(), roles);
//        , account.getFullName(), account.getEmail(), account.getAddress(), account.getPhoneNumber(), account.getAvatar()
    }
}
