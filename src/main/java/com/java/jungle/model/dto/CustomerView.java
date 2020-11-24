package com.java.jungle.model.dto;


public class CustomerView {
    //select p.id,i.id,p.desc,p.price,p.weight,p.pictureurl,i.qty FROM inventory i JOIN parts p where p.id = i.partid;
    private Integer partID;

    private Integer inventoryID;

    private String desc;

    private float price;

    private float weight;

    private String pictureURL;

    private int qty;

    public CustomerView(int partID, int inventoryID, String desc, float price, float weight, String pictureURL, int qty) {
        this.partID = partID;
        this.inventoryID = inventoryID;
        this.desc = desc;
        this.price = price;
        this.weight = weight;
        this.pictureURL = pictureURL;
        this.qty = qty;
    }



    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}