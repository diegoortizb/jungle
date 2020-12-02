package com.java.jungle.service;

import com.java.jungle.model.Cart;
import com.java.jungle.model.Orders;
import com.java.jungle.repository.Parts.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @ModelAttribute("parts")
    public List<Orders> findAll(){return ordersRepository.findAll();}
    //public List<Orders> findAll(){return ordersRepository.searchedByStatus();}
    public List <String> findAllByEmail(){return ordersRepository.findAllByEmail();}

    public void addItemToOrders(Integer item_id, Integer quantity, String email) {
        Orders item = new Orders(item_id, quantity, email);
        ordersRepository.save(item);
    }

    public List<Orders> findOrdersOf(String email){
        return ordersRepository.findOrdersOf(email);
    }

    public void removeItemFromOrders(int id) {
        ordersRepository.deleteById(id);

    }

    public void updateStatus(int id, int status) {
        Orders order = ordersRepository.findById(id).get();
        order.setStatus(status);
        ordersRepository.save(order);
    }

    public List<Orders> searchByStatus(int status) {
        return ordersRepository.searchedByStatus(status);
    }

    public List<Orders> searchByPrice(float price1, float price2) {
        return ordersRepository.searchedByPrice(price1, price2);
    }

    public List<Orders> searchByDate(java.sql.Date date1, java.sql.Date date2) {
        return ordersRepository.searchedByDate(date1, date2);
    }

}