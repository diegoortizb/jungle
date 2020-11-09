package com.java.jungle.model;
import javax.persistence.*;

@Entity
@Table(name = "parts") //also exists in the other databases, was created by mistake
public class db2Entity {
    @Id
    @GeneratedValue
    @Column(name = "number")
    private Integer number;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Float price;
    @Column(name = "weight")
    private Float weight;
    @Column(name = "pictureURL")
    private String picture;
    public db2Entity(){}

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
