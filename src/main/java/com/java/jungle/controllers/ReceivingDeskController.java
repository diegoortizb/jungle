package com.java.jungle.controllers;

import com.java.jungle.service.Db2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rd")
public class ReceivingDeskController {

    @Autowired
    private Db2Service parts;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("parts", parts.findAll());
        return "receivingDesk";
    }
}
