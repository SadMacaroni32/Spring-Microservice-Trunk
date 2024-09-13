package com.order.orderservice.dto;

public class ProductDTO {
    private String id;
    private String name;
    private Double price;
    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductDTO(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }



}
