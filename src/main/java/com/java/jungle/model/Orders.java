package com.java.jungle.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue
    @Column (name = "id")
    private Integer id;
    @Column (name = "item_id")
    private Integer item_id;
    @Column (name = "qty")
    private Integer qty;
    @Column (name = "email")
    private String email;
    @Column (name = "status")
    private Boolean status;
    public Orders(){}
    public Orders(Integer givenItem_id, Integer givenQuantity, String givenEmail){
        item_id = givenItem_id;
        qty = givenQuantity;
        email = givenEmail;
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

    public Boolean getStatus() {
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

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
