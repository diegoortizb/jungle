package com.java.jungle.service;

import com.java.jungle.model.Cart;
import com.java.jungle.model.Parts;
import com.java.jungle.model.Taxes;
import com.java.jungle.repository.Parts.CartRepository;
import com.java.jungle.repository.Parts.PartsRepository;
import com.java.jungle.repository.Parts.TaxesRepository;
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

    @Autowired
    TaxesRepository taxRepo;

    @Autowired
    PartsRepository partsRepository;

    @ModelAttribute("cart")
    public List<Cart> findAll() {
        return cartRepo.findAll();
    }

    public void updateQty(int id, int qty) {
        Cart item = cartRepo.findById(id).get();
        item.setQty(qty);
        cartRepo.save(item);
    }

    public void addItemToCart(int partID, String description, float price, float weight) {
        Cart item = new Cart(partID,description,price, weight);
        cartRepo.save(item);
    }

    public float getTotalInCart() {
        List<Cart> Cart = cartRepo.findAll();
        float total = 0;
        for (Cart Item : Cart) {
            total += Item.getPrice() * Item.getQty();
        }
        return total;
    }

    public float getTotalAfterTaxes() {
        float totalAfterTaxes = 0;
        float total = getTotalInCart();
        List<Cart> cart = cartRepo.findAll();
        List<Taxes> taxBracket = taxRepo.findAll();
        float weight = 0;

        for (Cart item : cart) {
            weight += item.getWeight() * item.getQty();
        }

        float tax = 0;
        for (Taxes currentBracket : taxBracket) {
            if (weight > currentBracket.getWeightBracket()) {
                tax = currentBracket.getTaxRate();
                break;
            }
        }

        totalAfterTaxes = total + (total * tax);

        return totalAfterTaxes;
    }

    public float getTaxRate() {
        List<Cart> cart = cartRepo.findAll();
        List<Taxes> taxBracket = taxRepo.findAll();
        float weight = 0;

        for (Cart item : cart) {
            weight += item.getWeight() * item.getQty();
        }

        float tax = 0;
        for (Taxes currentBracket : taxBracket) {
            if (weight > currentBracket.getWeightBracket()) {
                tax = currentBracket.getTaxRate();
                break;
            }
        }
        return tax * 100;
    }

    public void removeItemFromCart(int id) {
        cartRepo.deleteById(id);
    }
}
