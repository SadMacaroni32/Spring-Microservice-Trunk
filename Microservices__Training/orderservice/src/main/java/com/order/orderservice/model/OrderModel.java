package com.order.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderModel {

    @Id
    private String id;
    private String productId;
    private int quantity;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}
