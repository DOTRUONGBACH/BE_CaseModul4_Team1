package com.backend.controller;

import com.backend.model.Account;
import com.backend.model.Bill;
import com.backend.model.Cart;
import com.backend.model.CartItems;
import com.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    CartItemsService cartItemsService;

    @Autowired
    BillStatusService billStatusService;
    @Autowired
    BillService billService;
    @Autowired
    CartService cartService;

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

    @PostMapping("/bill/{username}")
    public void saveBill(@RequestBody Bill bill, @PathVariable String username) {
        Cart cart = cartService.findCartByUsername(username);
        bill.setCart(cart);
        bill.setAccount(accountService.findAccountByUsername(username));
        bill.setBillStatus(billStatusService.findBillStatusById(1L));
        Date date = new Date();
        String d = date.toString();
        bill.setDate(d);
        billService.saveBill(bill);
        cartService.deleteCart(username);
    }
    @GetMapping("/bill/{username}")
    public List<Bill> getAllBill(@PathVariable String username) {
        return billService.getAllBillByAccount(username);
    }
}
