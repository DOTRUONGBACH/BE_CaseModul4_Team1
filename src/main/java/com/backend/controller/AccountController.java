package com.backend.controller;

import com.backend.model.Account;
import com.backend.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @PostMapping
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        accountService.delete(id);
    }

    @PostMapping("/upImg")
    public String upImg(@RequestParam MultipartFile fileImg) {
        String nameImg = fileImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(fileImg.getBytes(), new File("D:\\CODEGYM\\Modul_4\\BaiTap\\CaseStudy_Modul4\\FE_CaseModul4_Team1\\images\\avatar\\" + nameImg));
            return "/avatar/" + nameImg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
