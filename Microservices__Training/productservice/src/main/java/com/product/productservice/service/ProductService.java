package com.product.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.productservice.model.Product;
import com.product.productservice.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepostiory;

    public List<Product> getAllProducts(){
        return productRepostiory.findAll();
    }

    public Product getProductById(String id){
        return productRepostiory.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepostiory.save(product);
    }

}
