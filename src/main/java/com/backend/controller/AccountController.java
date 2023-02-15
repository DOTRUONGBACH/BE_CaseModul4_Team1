package com.backend.controller;

import com.backend.model.Account;
import com.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/findAccountByUsername")
    public Account getAccountByUsername(@RequestBody String userName) {
        return accountService.findAccountByUsername(userName);
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable Long id) {
        return accountService.findAccountById(id);
    }

    @PostMapping
    public Account save(Account account) {
        return accountService.save(account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        accountService.delete(id);
    }
}
