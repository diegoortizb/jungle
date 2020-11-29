package com.java.jungle.controllers;

import com.java.jungle.service.Db2Service;
import com.java.jungle.service.OrdersService;
import com.java.jungle.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ws")
public class WorkStationController {

    @Autowired
    private OrdersService orders;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("orders", orders.findAll());
        model.addAttribute("Emails", orders.findAllByEmail());
        return "workstation";
    }

    @RequestMapping (value = "/ws", method = RequestMethod.DELETE)
    public ResponseEntity removeOrder(@RequestParam(value = "id") Integer id){
        try {
            orders.removeItemFromOrders(id);
        }
        catch(Exception e){
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping (value = "/ws", method = RequestMethod.POST)
    public String updateStatus(@RequestParam(value = "id") int id, @RequestParam(value = "status") Boolean status){
        orders.updateStatus(id,status);
        return "redirect:/ws";
    }
}