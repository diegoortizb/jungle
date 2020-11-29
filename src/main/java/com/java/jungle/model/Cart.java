package com.java.jungle.model;

import com.java.jungle.model.Parts;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "partID")
    private Integer partID;

    @Column(name = "item")
    private String item;

    @Column(name = "price")
    private float price;

    @Column(name = "qty")
    private int qty;

    @Column(name = "weight")
    private float weight;

    public Cart(int partID, String item, float price, float weight) {
        this.partID = partID;
        this.item = item;
        this.price = price;
        this.qty = 1;
        this.weight = weight;
    }

    public Cart(String item, float price) {
        this.item = item;
        this.price = price;
        this.qty = 1;
    }

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItems(String item) {
        this.item = item;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
