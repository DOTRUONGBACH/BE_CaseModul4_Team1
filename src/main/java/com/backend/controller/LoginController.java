package com.backend.controller;

import com.backend.model.Account;
import com.backend.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;
    @PostMapping
    public String login(@RequestBody Account account) {
        // tạo ra 1 đối tượng xác thực
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUserName(), account.getPassWord())
        );
        // nơi chứa đối tượng đang đăng nhập
        // truyền đối tượng đăng nhập vào securityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // tạo ra token
        String token = jwtService.createToken(authentication);
        return token;
    }
}
