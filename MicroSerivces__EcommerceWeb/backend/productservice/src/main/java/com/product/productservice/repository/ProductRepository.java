package com.product.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.productservice.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

}
