package com.java.jungle.controllers;

import com.java.jungle.service.AdminService;
import com.java.jungle.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/admin", method= RequestMethod.GET)
    public String admin (Model model) {
        model.addAttribute("taxes", adminService.findAll());
        return "admin";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST)
    public String updateQty(@RequestParam(value="id") int id,
                            @RequestParam(value="taxRate") float taxRate) {
        adminService.updateQty(id,taxRate);
        return "redirect:/admin";
    }
}
