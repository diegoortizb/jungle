package com.java.jungle.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "partID")
    private Integer item_id;

    @Column (name = "qty")
    private Integer qty;

    @Column (name = "email")
    private String email;

    @Column (name = "status")
    private int status;

    @Column (name = "name")
    private String name;

    @Column (name = "mailingAddress")
    private String mailingAddress;

    @Column (name = "price")
    private float price;

    public Orders(){}
    public Orders(Integer givenItem_id, Integer givenQuantity, String givenEmail){
        item_id = givenItem_id;
        qty = givenQuantity;
        email = givenEmail;
    }

    public Orders(String email, String name, String mailingAddress, float price, int partID, int qty) {
        this.email = email;
        this.name = name;
        this.mailingAddress = mailingAddress;
        this.price = price;
        this.item_id = partID;
        this.status = 1;
        this.qty = qty;
    }

    public Integer getId() {
        return id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public Integer getQty() {
        return qty;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
