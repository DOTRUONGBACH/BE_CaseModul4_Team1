package com.backend.service;

import com.backend.model.Cart;
import com.backend.model.CartItems;
import com.backend.repo.ICartItemsRepo;
import com.backend.repo.ICartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    ICartRepo iCartRepo;
    public Cart findCartByUsername(String username) {
       return iCartRepo.findCartByAccount_UserName(username);
    }
    public Cart saveCart(String username) {
        Cart cart = findCartByUsername(username);
        if(cart==null) {
            return iCartRepo.save(cart);
        } else return iCartRepo.save(iCartRepo.save(cart));
    }
    public Cart save(Cart cart) {
        return iCartRepo.save(cart);
    }
}
