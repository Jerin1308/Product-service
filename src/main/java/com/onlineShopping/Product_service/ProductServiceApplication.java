package com.onlineShopping.Product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}


/* 

1. Product Service
	Interfaces
		ProductService
			Methods:
				Product getProductById(Long productId);
				List<Product> getAllProducts();
				List<Product> getProductsByCategory(Long categoryId);
				void addProduct(Product product);
				void updateProduct(Product product);
				void deleteProduct(Long productId);
	Classes
		Product
			Attributes:
				Long id;
				String name;
				String description;
				Double price;
				Long categoryId;
				Integer inventoryCount;
ProductServiceImpl (implements ProductService)
	Methods:
		Implement all methods defined in the ProductService interface.

*/


/* 


3. APIs
	Product Service APIs:
		GET /products - Fetch all products.
		POST /products - Add a new product.
		PUT /products/{id} - Update a product.
		DELETE /products/{id} - Remove a product.

*/