package com.java.jungle.controllers;

import com.java.jungle.service.AdminService;
import com.java.jungle.service.OrdersService;
import com.java.jungle.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.AttributeOverride;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public String admin (@RequestParam(value="price1", required = false) Float price1,
                         @RequestParam(value="price2", required = false) Float price2,
                         @RequestParam(value="status", required = false) Integer status,
                         @RequestParam(value="date1", required = false) java.sql.Date date1,
                         @RequestParam(value="date2", required = false) java.sql.Date date2,
                         @RequestParam(value="searchType", required = false) Integer searchType, Model model) {
        if(searchType != null) {

            switch (searchType) {
                case 1:
                    model.addAttribute("viewAllOrders", ordersService.searchByStatus(status));
                    break;
                case 2:
                    model.addAttribute("viewAllOrders", ordersService.searchByPrice(price1, price2));
                    break;
                case 3:
                    model.addAttribute("viewAllOrders", ordersService.searchByDate(date1, date2));
                    break;
                default:
                    model.addAttribute("viewAllOrders", ordersService.findAll());
            }
        }
        else {model.addAttribute("viewAllOrders", ordersService.findAll());}
        model.addAttribute("taxes", adminService.findAll());

        return "admin";
    }

    @RequestMapping(value="/admin", method=RequestMethod.POST)
    public String updateQty(@RequestParam(value="id") int id,
                            @RequestParam(value="taxRate") float taxRate) {
        adminService.updateQty(id,taxRate);

        return "redirect:/admin";
    }

    @RequestMapping(value="/admin/searchedByStatus", method=RequestMethod.GET)
    public String searchStatus(@RequestParam(value="status") int status, Model model) {
        model.addAttribute("searchStatus", ordersService.searchByStatus(status));

        return "admin";
    }

    /*@RequestMapping(value="/admin", method=RequestMethod.GET)
    public String searchPrice(@RequestParam(value="price1") float price1,
                              @RequestParam(value="price2") float price2, Model model) {
        model.addAttribute("viewAllOrders", ordersService.searchByPrice(price1, price2));
        model.addAttribute("taxes", adminService.findAll());

        return "redirect:/admin";
    }*/

}
