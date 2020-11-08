package com.java.jungle.service;

import com.java.jungle.model.Cart;
import com.java.jungle.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepo;

    @ModelAttribute("cartItems")
    public List<Cart> findAll() {
        return this.cartRepo.findAll();
    }
}
