package com.java.jungle.controllers;

import com.java.jungle.repository.PartsRepository;
import com.java.jungle.resource.UsersResource;
import com.java.jungle.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private PartsService partsService;

    @GetMapping
    public String home (Model model) {
        model.addAttribute("parts", partsService.findAll());
        return "customer";
    }

    @GetMapping("/{partid}")
    public String test () {
        return "tabs";
    }
}