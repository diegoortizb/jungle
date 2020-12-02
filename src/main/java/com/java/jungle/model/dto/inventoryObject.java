package com.java.jungle.model.dto;

public class inventoryObject {

    private int qty;

    private int partId;

    private int id;

    public inventoryObject(int id,int partId, int qty) {
        this.id = id;
        this.partId = partId;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}
