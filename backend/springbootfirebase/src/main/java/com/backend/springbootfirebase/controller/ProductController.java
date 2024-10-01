package com.backend.springbootfirebase.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.backend.springbootfirebase.entity.Product;
import com.backend.springbootfirebase.service.ProductService;

import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")  // Fixed the closing quote
    public String saveProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {  // Corrected the Exception name

        return productService.saveProduct(product);  // Call to the service layer to save the product
    }
}
