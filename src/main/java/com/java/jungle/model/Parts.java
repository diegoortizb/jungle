package com.java.jungle.model;
import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Parts {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer number;
    @Column(name = "desc")
    private String description;
    @Column(name = "price")
    private Float price;
    @Column(name = "weight")
    private Float weight;
    @Column(name = "pictureURL")
    private String picture;
    public Parts(){}

    public Parts(Integer number, String description, Float price, Float weight, String picture) {
        this.number = number;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.picture = picture;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public Float getWeight() {
        return weight;
    }

    public String getPicture() {
        return picture;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
