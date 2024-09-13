package com.product.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
