package com.commerce.produit.service.repository;

import com.commerce.produit.service.dto.ProductRequest;
import com.commerce.produit.service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
