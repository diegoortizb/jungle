package com.java.jungle.service;

import com.java.jungle.model.Cart;
import com.java.jungle.repository.Parts.CartRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;


@Service
public class CartService {
    @Autowired
    CartRepository cartRepo;

    @ModelAttribute("cart")
    public List<Cart> findAll() {
        return cartRepo.findAll();
    }

    public void addItemToCart(String description, float price) {
        Cart item = new Cart(description,price);
        cartRepo.save(item);
    }

    public void removeItemFromCart(int id) {
        cartRepo.deleteById(id);
    }
}
