package com.java.jungle.model;

import javax.persistence.*;

@Entity
@Table(schema = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "item")
    private String item;
    @Column(name = "price")
    private float price;

    public Cart(int id, String item, Float price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
