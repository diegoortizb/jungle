package com.java.jungle.controllers;

import com.java.jungle.repository.Parts.PartsRepository;
import com.java.jungle.service.CustomerService;
import com.java.jungle.service.Db2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;

@Controller
public class ReceivingDeskController {

    @Autowired
    private PartsRepository partsRepo;

    @Autowired
    private CustomerService customerService;
//    private Db2Service parts;

    @GetMapping
    @RequestMapping(value="/rd", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("Inventory", partsRepo.getRDView());
//        model.addAttribute("Inventory", parts.findAll());
        return "receivingDesk";
    }

    @RequestMapping(value="/rd", method= RequestMethod.POST)
    public String addItemToCart(@RequestParam(value="partID") Integer partID,
                                @RequestParam(value="invUpdate") int updateQuantity) {

        //TODO: Update partID's quantity
        customerService.addQtyFromInventory(partID, updateQuantity);

        return "redirect:/rd";
    }
}
