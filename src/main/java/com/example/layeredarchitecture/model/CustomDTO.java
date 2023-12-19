package com.example.layeredarchitecture.model;

import java.math.BigDecimal;

public class CustomDTO {
    private String id;
    private String name;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

    public CustomDTO(){

    }
    public CustomDTO(String id,String name,String itemCode,int qty,BigDecimal unitPrice){
        this.id = id;
        this.name = name;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}