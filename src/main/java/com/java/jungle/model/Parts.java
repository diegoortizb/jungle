package com.java.jungle.model;
import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Parts {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "desc")
    private String desc;
    @Column(name = "price")
    private Float price;
    @Column(name = "weight")
    private Float weight;
    @Column(name = "pictureURL")
    private String pictureURL;
    public Parts(){}

    public Parts(Integer id, String desc, Float price, Float weight, String pictureURL) {
        this.id = id;
        this.desc = desc;
        this.price = price;
        this.weight = weight;
        this.pictureURL = pictureURL;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return desc;
    }

    public Float getPrice() {
        return price;
    }

    public Float getWeight() {
        return weight;
    }

    public String getPicture() {
        return pictureURL;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setPicture(String picture) {
        this.pictureURL = picture;
    }
}
