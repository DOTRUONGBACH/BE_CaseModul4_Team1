package com.backend.controller;

import com.backend.model.Account;
import com.backend.model.Role;
import com.backend.model.dto.AccountToken;
import com.backend.service.AccountService;
import com.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;
    @PostMapping
    public AccountToken login(@RequestBody Account account) {
        // tạo ra 1 đối tượng xác thực
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUserName(), account.getPassWord())
        );
        // nơi chứa đối tượng đang đăng nhập
        // truyền đối tượng đăng nhập vào securityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // tạo ra token
        String token = jwtService.createToken(authentication);
        Account account1 = accountService.findAccountByUsername(account.getUserName());
//        List<Role> roles = new ArrayList<>();
//        roles.add(account1.getRole());
        return new AccountToken(account.getUserName(), account1.getFullName(), account1.getEmail(), account1.getAddress(), account1.getPhoneNumber(), account1.getAvatar(), token, account1.getRole());
    }

}
