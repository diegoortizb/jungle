package com.java.jungle.controllers;

import com.java.jungle.model.dto.CustomerView;
import com.java.jungle.repository.Parts.InventoryRepository;
import com.java.jungle.repository.Parts.PartsRepository;
import com.java.jungle.service.CustomerService;
import com.java.jungle.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class CustomerController {

    private static Logger log;

    //
    //  Db2Service IS THE LEGACY DATABASE
    //
    @Autowired
    private PartsService partsService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PartsRepository partsRepo;

    //
    //  method retrieves main customer page
    //
    @RequestMapping(value="/customer", method=RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("CustomerView", partsRepo.getCustomerView());
        return "customer";
    }

    //
    // method enables user to add items to the cart
    //
    @RequestMapping(value="/customer", method=RequestMethod.POST)
    public String addItemToCart(@RequestParam(value="partID") Integer partID,
                                @RequestParam(value="description") String description,
                                @RequestParam(value="price") float price,
                                @RequestParam(value="weight") float weight,
                                @RequestParam(value="partQty") int partQty) {
        //TODO MUST ADD A WAY TO ADD 1 TO cart.qty IF ITEM IS ALREADY IN CART
        customerService.addItemToCart(partID,description, price, weight, partQty);

        return "redirect:/customer";
    }

    //
    //  method retrieves all items that was added to the shopping cart
    //
    @RequestMapping(value="/customer/cart", method=RequestMethod.GET)
    public String cart (Model model) {
        model.addAttribute("cart", customerService.findAll());
        model.addAttribute("total", customerService.getTotalInCart());
        model.addAttribute("taxRate", customerService.getTaxRate());
        model.addAttribute("totalTax", customerService.getTotalAfterTaxes());
        return "cart";
    }

    //
    //  method updates the shopping cart to the given quantity
    //
    @RequestMapping(value="/customer/cart", method=RequestMethod.POST)
    public String updateQty(@RequestParam(value="id") int id,
                            @RequestParam(value="qty") int qty) {
        customerService.updateQty(id,qty);
        return "redirect:/customer/cart";
    }

    // TODO THIS METHOD WILL DELETE ITEMS FROM THE SHOPPING CART
    //
    //
    @RequestMapping(value="/customer/cart", method=RequestMethod.DELETE)
    public ResponseEntity removeItemFromCart(@RequestParam(value="id") int id) {
        try {
            customerService.removeItemFromCart(id);
        } catch (Exception e) {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
