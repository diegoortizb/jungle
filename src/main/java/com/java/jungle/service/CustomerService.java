package com.java.jungle.service;

import com.java.jungle.model.Cart;
import com.java.jungle.model.Taxes;
import com.java.jungle.repository.Parts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private TaxesRepository taxRepo;

    @Autowired
    private PartsRepository partsRepository;

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
            }
        }
        return tax * 100;
    }

    public void removeItemFromCart(int id) {
        cartRepo.deleteById(id);
    }
}
