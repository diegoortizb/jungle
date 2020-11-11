package com.java.jungle.controllers;

import com.java.jungle.model.Cart;
import com.java.jungle.service.CartService;
import com.java.jungle.service.Db2Service;
import com.java.jungle.service.PartsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.logging.Logger;

@Controller
public class CustomerController {

    private static Logger log;

    //
    //  Db2Service IS THE LEGACY DATABASE
    //
    @Autowired
    private Db2Service partsService;

    @Autowired
    private CartService cartService;

    @RequestMapping(value="/customer", method=RequestMethod.GET)
    public String home (Model model) {
        model.addAttribute("parts", partsService.findAll());
        model.addAttribute("cart", cartService.findAll());
        return "customer";
    }

    @RequestMapping(value="/customer", method=RequestMethod.POST)
    public ResponseEntity addItemToCart(@RequestParam(value="description") String description,
                                        @RequestParam(value="price") int price) {
        //can make a workaround to find last item on the cart
        // (highest id val) and just add one to it

        cartService.addItemToCart(description, price);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
