package com.backend.controller;

import com.backend.model.CartItems;
import com.backend.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartItemsService cartItemsService;


    @GetMapping("/{id}")
    public List<CartItems> getCart(@PathVariable long id) {
        return cartItemsService.findAllCartItemsByIdAccount(id);
    }
}
