package com.java.jungle.model;

import com.java.jungle.model.Parts;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "items")
    private String items;

    @Column(name = "price")
    private int price;

    public Cart(Integer id, String items, int price) {
        this.id = id;
        this.items = items;
        this.price = price;
    }

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
