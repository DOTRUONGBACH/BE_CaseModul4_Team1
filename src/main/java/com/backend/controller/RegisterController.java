package com.backend.controller;

import com.backend.model.Account;
import com.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    AccountService accountService;

    @PostMapping
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PostMapping("/checkUsername/{username}")
    public ResponseEntity<Boolean> checkDuplicateUsername(@PathVariable String username) {
        return new ResponseEntity<>(accountService.checkDuplicateByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/checkEmail/{email}")
    public ResponseEntity<Boolean> checkDuplicateEmail(@PathVariable String email) {
        return new ResponseEntity<>(accountService.checkDuplicateByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("D:\\CODEGYM\\Modul_4\\BaiTap\\CaseStudy_Modul4\\FE_CaseModul4_Team1\\images\\avatar\\" + nameImg));
            return "/images/avatar/" + nameImg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
