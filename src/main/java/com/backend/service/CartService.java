package com.backend.service;

import com.backend.model.CartItems;
import com.backend.repo.ICartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    ICartRepo iCartRepo;

}
