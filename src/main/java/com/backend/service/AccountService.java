package com.backend.service;

import com.backend.model.Account;
import com.backend.model.Role;
import com.backend.repository.IAccountRepo;
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

    public Account findAccountByUsername(String username) {
        return iAccountRepo.findAccountByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findAccountByUserName(username);
        List<Role> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUserName(), account.getPassWord(), roles);
//        , account.getFullName(), account.getEmail(), account.getAddress(), account.getPhoneNumber(), account.getAvatar()
    }
}
