package com.commerce.produit.service.controller;

import com.commerce.produit.service.business.ProductService;
import com.commerce.produit.service.dto.ProductResponse;
import com.commerce.produit.service.model.Product;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")

public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
    }

    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        return new ResponseEntity<>(productService.addProduct(productService.addProduct(product)), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity <List<Product>> getAllProducts(){

        return new ResponseEntity<>( productService.getAllProducts(),HttpStatus.OK);

    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        return productService.getProductById(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

        return new ResponseEntity<>(productService.updateProduct(product,id), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
