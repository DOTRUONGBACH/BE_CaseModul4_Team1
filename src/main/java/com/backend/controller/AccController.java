package com.backend.controller;

import com.backend.model.Account;
import com.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AccController {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> show() {
        return new ResponseEntity<>(accountService.findALl(), HttpStatus.OK);
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        accountService.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable long id) {
        accountService.delete(id);
    }

    @PutMapping("/accounts/{id}")
    public void update(@RequestBody Account account) {
        accountService.save(account);
    }
}
