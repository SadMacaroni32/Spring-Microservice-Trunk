package com.product.productservice.service;

import com.product.productservice.model.ProductModel;
import com.product.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductModel> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public ProductModel saveProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
