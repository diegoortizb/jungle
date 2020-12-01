package com.java.jungle.controllers;

import com.java.jungle.repository.Parts.PartsRepository;
import com.java.jungle.service.Db2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rd")
public class ReceivingDeskController {

    @Autowired
    private PartsRepository partsRepo;
//    private Db2Service parts;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("Inventory", partsRepo.getCustomerView());
//        model.addAttribute("Inventory", parts.findAll());
        return "receivingDesk";
    }

    @RequestMapping(value="/rd", method= RequestMethod.POST)
    public String addItemToCart(@RequestParam(value="partID") Integer partID,
                                @RequestParam(value="invUpdate") int updateQuantity) {

        //TODO: Update partID's quantity

        return "redirect:/rd";
    }
}
