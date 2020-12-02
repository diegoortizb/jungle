package com.java.jungle.model.dto;

import java.sql.Date;

public class OrdersView {
    private String description;
    private int orderid;
    private int item_id;
    private int qty;
    private int status;
    private Date subDate;
    private String mailingAddress;
    private float price;
    private String email;
    private String name;

    public OrdersView(String description, Integer item_id, Integer qty, Integer status,Integer orderid, Date subDate, String mailingAddress, float price, String email, String name) {
        this.description = description;
        this.item_id = item_id;
        this.qty = qty;
        this.status = status;
        this.subDate = subDate;
        this.mailingAddress = mailingAddress;
        this.price = price;
        this.email = email;
        this.name = name;
        this.orderid = orderid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItem_id() {
        return item_id;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public int getOrderid() {
        return orderid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
