package com.product.productservice.controller;

import com.product.productservice.model.ProductModel;
import com.product.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
        
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable Long id) {
        Optional<ProductModel> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product) {
        ProductModel savedProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel product) {
        if (productService.getProductById(id).isPresent()) {
            product.setId(id);
            ProductModel updatedProduct = productService.saveProduct(product);
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (productService.getProductById(id).isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
