package com.backend.controller;

import com.backend.model.Account;
import com.backend.model.CartItems;
import com.backend.service.AccountService;
import com.backend.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    CartItemsService cartItemsService;

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
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

    //    giỏ hàng:
    @GetMapping("/cart/{username}")
    public List<CartItems> getCartByIdAccount(@PathVariable String username) {
        return cartItemsService.findAllCartItemsByIdAccount(accountService.findAccountByUsername(username).getId());
    }

    @PostMapping("/cart/{username}")
    public void addProductToCart(@PathVariable String username, @RequestBody CartItems cartItems) {
        accountService.checkCartInAccount(username, cartItems);
    }
}
