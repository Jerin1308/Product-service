package com.onlineShopping.Product_service.Service;

import java.util.List;

import com.onlineShopping.Product_service.Model.Product;
import com.onlineShopping.Product_service.Request.ProductRequest;
import com.onlineShopping.Product_service.Response.ProductResponse;

public interface ProductService {

    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long productId);
    ProductResponse addProduct(ProductRequest request);
    ProductResponse updateProduct(Long productId, ProductRequest request);
    void deleteProduct(Long productId);
    List<Product> filterByPrice(Double price);
    List<ProductResponse> getProductsByCategory(Long categoryId);
    List<Product> filterByInventory(Long minInventory);

}
