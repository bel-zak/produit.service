package com.commerce.produit.service.business;

import com.commerce.produit.service.exceptions.ResourceNotFoundException;
import com.commerce.produit.service.model.Product;
import com.commerce.produit.service.repository.ProductRepository;
import com.sun.jdi.request.ExceptionRequest;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.xml.transform.ResourceSource;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }



    public Product updateProduct(Product product, Long id) {

        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
           product.setId(id);
            return productRepository.save(product);
        } else {
            String s = "Product not found with id " + product.getId();
            throw new ResourceNotFoundException(s);
        }

        }




    public void deleteProduct(Long id) {

        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
          productRepository.deleteById(id);;
        } else {
            String s = "Product not found with id " + id;
            throw new ResourceNotFoundException(s);
        }

    }

    }

