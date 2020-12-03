package com.java.jungle.controllers;

import com.fasterxml.jackson.databind.node.TextNode;
import com.java.jungle.component.EmailComponent;
import com.java.jungle.model.Orders;
import com.java.jungle.model.dto.OrdersView;
import com.java.jungle.service.Db2Service;
import com.java.jungle.service.OrdersService;
import com.java.jungle.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/ws")
public class WorkStationController {

    @Autowired
    private OrdersService orders;

    @Autowired
    private EmailComponent emailService;

    @RequestMapping(value="/ws", method=RequestMethod.GET)
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
    //@RequestMapping(value = "/ordersof", method = RequestMethod.GET)
    @GetMapping(value = "/ws/ordersof", produces = "application/json")
    public @ResponseBody List<OrdersView> findOrdersOf(@RequestParam String email){
        return orders.findOrdersOf(email);
    }

    @RequestMapping (value = "/ws/update", method = RequestMethod.POST)
    public ResponseEntity updateStatus(@RequestParam(value = "id") String id){
        try{orders.updateStatus(Integer.parseInt(id));}
        catch (Exception e){
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping (value = "/sendEmail", method = RequestMethod.POST)
    public ResponseEntity sendEmail(@RequestBody TextNode email){
        try{emailService.sendSimpleMessage(email.asText());}
        catch (Exception e){
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}