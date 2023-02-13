package com.backend.controller;

import com.backend.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
//    @PostMapping
//    public String login(@RequestBody Account account) {
//
//    }
}
