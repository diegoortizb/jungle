package com.java.jungle.controllers;

import com.java.jungle.service.CartService;
import com.java.jungle.service.Db2Service;
import com.java.jungle.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //
    //  Db2Service IS THE LEGACY DATABASE
    //
    @Autowired
    private Db2Service partsService;

    @Autowired
    private CartService cartService;

    @GetMapping
    public String home (Model model) {
        model.addAttribute("parts", partsService.findAll());
        model.addAttribute("cart", cartService.findAll());
        return "customer";
    }

    @GetMapping("/{partid}")
    public String test () {
        return "tabs";
    }
}
