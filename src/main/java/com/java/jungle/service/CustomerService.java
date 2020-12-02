package com.java.jungle.service;

import com.java.jungle.model.Cart;
import com.java.jungle.model.Inventory;
import com.java.jungle.model.Orders;
import com.java.jungle.model.Taxes;
import com.java.jungle.model.dto.inventoryObject;
import com.java.jungle.repository.Parts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private TaxesRepository taxRepo;

    @Autowired
    private PartsRepository partsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @ModelAttribute("cart")
    public List<Cart> findAll() {
        return cartRepo.findAll();
    }

    public void updateQty(int id, int qty) {
        Cart item = cartRepo.findById(id).get();
        if (qty == 0) {
            cartRepo.delete(item);
        } else {
            item.setQty(qty);
            cartRepo.save(item);
        }
    }

    @Transactional
    public void subtractQtyFromInventory() {
        List<Cart> cart = findAll();

        for (Cart item : cart) {
            List<inventoryObject> inventory = inventoryRepository.searchByPartId(item.getId());
            for (inventoryObject itemInventory : inventory) {
                inventoryRepository.updateQty(itemInventory.getQty() - item.getQty(), itemInventory.getId());
            }
        }
    }

    public void clearCart() {
        cartRepo.deleteAll();
    }

    public void addOrder(String name, String email, String address) {
        List<Cart> cart = cartRepo.findAll();
        Date date = new Date();
        for (Cart part : cart) {
            Orders order = new Orders(email,name,address,part.getPrice(),part.getId(), part.getQty(), date);
            ordersRepository.save(order);
        }
    }

    public void addItemToCart(int partID, String description, float price, float weight, int partQty) {
        Cart item = new Cart(partID,description,price, weight, partQty);
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
