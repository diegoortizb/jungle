package com.java.jungle.model;

import javax.persistence.*;

@Entity
@Table(name = "taxes")
public class Taxes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "weightBracket")
    private int weightBracket;

    @Column(name = "taxRate")
    private float taxRate; // ex: 0.15 -> 15%?

    public Taxes(int weightBracket, float taxRate) {
        this.weightBracket = weightBracket;
        this.taxRate = taxRate;
    }

    public Taxes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getWeightBracket() {
        return weightBracket;
    }

    public void setWeightBracket(int weightBracket) {
        this.weightBracket = weightBracket;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }
}
