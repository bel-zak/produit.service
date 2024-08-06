package com.commerce.produit.service.controller;

import com.commerce.produit.service.business.ProductService;
import com.commerce.produit.service.model.Product;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api")

public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
    }

    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product createProduct = productService.addProduct(product);
        return new ResponseEntity<>(createProduct, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity <List<Product>> getAllProducts(){

        List<Product> products= productService.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);

    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }


    @DeleteMapping("/delete/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
