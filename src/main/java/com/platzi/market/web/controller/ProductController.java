package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    public ResponseEntity<Optional<Product>> getProduct(int productId) {
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    public ResponseEntity<Optional<List<Product>>> getByCategory(int categoryId) {
        return ResponseEntity.ok(productService.getByCategory(categoryId));
    }

    public ResponseEntity<Product> save(Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    public ResponseEntity<Boolean> delete(int productId) {
        return ResponseEntity.ok(productService.delete(productId));
    }
}
