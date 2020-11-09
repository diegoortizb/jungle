package com.java.jungle.service;

import com.java.jungle.model.Cart;
import com.java.jungle.repository.Parts.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Service
public class CartService {
    @Autowired
    CartRepository cartRepo;

    @ModelAttribute("cart")
    public List<Cart> findAll(){return cartRepo.findAll();}
}
