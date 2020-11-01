package com.java.jungle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ws")
public class WorkStationController {

    @GetMapping
    public String home(Model model) {
        return "workstation";
    }
}
