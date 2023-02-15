package com.backend.service;

import com.backend.model.CartItems;
import com.backend.repo.ICartItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemsService {
    @Autowired
    ICartItemsRepo iCartItemsRepo;
//    public List<CartItems> getAllCartItems() {
//       return (List<CartItems>) iCartItemsRepo.findAll();
//    }
    public List<CartItems> findAllCartItemsByIdAccount(long id) {
        return iCartItemsRepo.findAllCartItemsByIdAccount(id);
    }
}
