package com.backend.service;

import com.backend.model.Cart;
import com.backend.model.CartItems;
import com.backend.repo.IAccRepo;
import com.backend.repo.ICartItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartItemsService {

    @Autowired
    ICartItemsRepo iCartItemsRepo;
    @Autowired
    IAccRepo iAccRepo;
//    public List<CartItems> getAllCartItems() {
//       return (List<CartItems>) iCartItemsRepo.findAll();
//    }
    public long getIdAccountByUsername(String username) {
        return iAccRepo.findAccountByUserName(username).getId();
    }

    public List<CartItems> findAllCartItemsByIdAccount(long id) {
        return iCartItemsRepo.findAllCartItemsByIdAccount(id);
    }
    public void addToCart(CartItems item, Cart cart) {
        CartItems cartItems = iCartItemsRepo.findCartItemsByProductAndCart_Id(item.getProduct(), cart.getId());
        if(cartItems==null) {
            iCartItemsRepo.save(item);
        } else {
            cartItems.setAmount(cartItems.getAmount()+1);
            item.setCart(cart);
            iCartItemsRepo.save(cartItems);
        }
    }


}
