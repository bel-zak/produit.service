package com.commerce.produit.service.business;
import com.commerce.produit.service.model.Product;
import com.commerce.produit.service.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    public ProductServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setStockQuantity(100);
        product.setPrice(50.0);

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = productService.addProduct(product);
        assertEquals(product.getName(), result.getName());
    }

    @Test
    void testGetAllProducts() {
        Product product1 = new Product();
        product1.setName("Product 1");
        Product product2 = new Product();
        product2.setName("Product 2");

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.getAllProducts();
        assertEquals(2, result.size());
    }

    @Test
    void testGetProductById() {
        Product product = new Product();
        product.setName("Test Product");

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> result = productService.getProductById(1L);
        assertEquals("Test Product", result.get().getName());
    }

    @Test
    void testUpdateProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Updated Product");

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = productService.updateProduct(product);
        assertEquals("Updated Product", result.getName());
    }

    @Test
    void testDeleteProduct() {
        productService.deleteProduct(1L);
        verify(productRepository, times(1)).deleteById(1L);
    }
}