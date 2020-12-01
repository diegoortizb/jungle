package com.java.jungle.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue
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
    @Column (name = "subDate")
    private java.sql.Date subDate  ;

    public Orders(){}
    public Orders(Integer givenItem_id, Integer givenQuantity, String givenEmail, int givenStatus, String givenName, String givenMailingAddress, float givenPrice, java.sql.Date givenSubDate){
        item_id = givenItem_id;
        qty = givenQuantity;
        email = givenEmail;
        status = givenStatus;
        name = givenName;
        mailingAddress = givenMailingAddress;
        price = givenPrice;
        subDate = givenSubDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public java.sql.Date getSubDate() {
        return subDate;
    }

    public void setSubDate(java.sql.Date subDate) {
        this.subDate = subDate;
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
