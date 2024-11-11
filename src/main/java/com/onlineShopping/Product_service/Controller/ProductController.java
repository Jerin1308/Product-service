package com.onlineShopping.Product_service.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onlineShopping.Product_service.Model.Product;
import com.onlineShopping.Product_service.Request.ProductRequest;
import com.onlineShopping.Product_service.Response.ProductResponse;
import com.onlineShopping.Product_service.Service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Get all products
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long productId) {
        ProductResponse product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Add a new product
    @PostMapping("/addProduct")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {
        ProductResponse newProduct = productService.addProduct(request);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable("id") Long productId,
            @RequestBody ProductRequest request) {
        ProductResponse updatedProduct = productService.updateProduct(productId, request);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }
    
    @GetMapping("/filter/price")
    public List<Product> filterByPrice(@RequestParam Double price) {
        return productService.filterByPrice(price);
    }

    @GetMapping("/filter/category")
    public List<ProductResponse> getProductsByCategory(@RequestParam Long category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/filter/inventory")
    public List<Product> filterByInventory(@RequestParam Long minInventory) {
        return productService.filterByInventory(minInventory);
    }
    
}