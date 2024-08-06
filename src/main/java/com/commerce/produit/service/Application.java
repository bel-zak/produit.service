package com.commerce.produit.service;

import com.commerce.produit.service.business.ProductService;
import com.commerce.produit.service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner (ProductService productService){
		return args -> {
			for (int i = 0; i < 10; i++) {
				productService.addProduct(
						Product.builder()
								.name("Product- "+i)
								.price(100.00)
								.stockQuantity(13)
								.build());
			}

		};
	}

}
