package com.backend.service;

import com.backend.model.Account;
import com.backend.model.Cart;
import com.backend.model.CartItems;
import com.backend.model.Role;
import com.backend.repo.IAccRepo;
import com.backend.repo.ICartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccRepo iAccRepo;
    @Autowired
    ICartRepo iCartRepo;
    @Autowired
    CartService cartService;
    @Autowired
    CartItemsService cartItemsService;

    public List<Account> getAll() {
        return (List<Account>) iAccRepo.findAll();
    }

    public Account save(Account account) {
        return iAccRepo.save(account);
    }

    public void delete(long id) {
        iAccRepo.deleteById(id);
    }

    public Account findAccountByUsername(String username) {
        Account account = iAccRepo.findAccountByUserName(username);
        return account;
    }

    public Account findAccountById(long id) {
        return iAccRepo.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccRepo.findAccountByUserName(username);
        List<Role> roles = new ArrayList<>();
        roles.add(account.getRole());
        return new User(account.getUserName(), account.getPassWord(), roles);
//        , account.getFullName(), account.getEmail(), account.getAddress(), account.getPhoneNumber(), account.getAvatar()
    }

//    Map<Long, Cart> maps = new HashMap<>();

    public void checkCartInAccount(String username, CartItems cartItems) {
        Cart cart = cartService.findCartByUsername(username);
//        Cart cart = maps.get(findAccountByUsername(username).getId());
        if (cart == null) {
            cart = new Cart();
            cart.setAccount(iAccRepo.findAccountByUserName(username));
            iCartRepo.save(cart);
        } else {
            cartItems.setCart(cart);
            cartItemsService.addToCart(cartItems,cart);
        }
    }
}
