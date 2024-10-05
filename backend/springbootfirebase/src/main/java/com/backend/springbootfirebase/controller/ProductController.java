package com.backend.springbootfirebase.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backend.springbootfirebase.entity.Product;
import com.backend.springbootfirebase.service.ProductService;

import java.util.List;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/products")  // Fixed the closing quote
        public String saveProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.saveProduct(product);
    }

    @GetMapping ("/products/{name}")  // Fixed the closing quote
    public Product getProduct(@PathVariable String name ) throws ExecutionException, InterruptedException {
        return productService.getProductDetails(name);
        }

    @GetMapping ("/products")  // Fixed the closing quote
    public List<Product> getAllProduct() throws ExecutionException, InterruptedException {
        return productService.getAllProductDetails();
        }

//    @PatchMapping("/products/{name}")
//    public String updateProduct(@PathVariable String name, @RequestBody Product updatedProduct) throws ExecutionException, InterruptedException {
//        return productService.updateProduct(name, updatedProduct);
//    }
    @PatchMapping("/products/{name}")
    public String updateProduct(@PathVariable String name, @RequestBody Product updatedProduct) throws ExecutionException, InterruptedException {
        return productService.updateProduct(name, updatedProduct);
    }


    @DeleteMapping ("/products/{name}")  // Fixed the closing quote
    public String deleteProduct(@PathVariable String name ) throws ExecutionException, InterruptedException {
        return productService.deleteProduct(name);
    }


}
