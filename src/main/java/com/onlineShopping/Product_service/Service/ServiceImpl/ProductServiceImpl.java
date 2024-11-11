package com.onlineShopping.Product_service.Service.ServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.onlineShopping.Product_service.Mapper.ProductMapper;
import com.onlineShopping.Product_service.Model.Category;
import com.onlineShopping.Product_service.Model.Product;
import com.onlineShopping.Product_service.Repository.ProductRepository;
import com.onlineShopping.Product_service.Request.ProductRequest;
import com.onlineShopping.Product_service.Response.ProductResponse;
import com.onlineShopping.Product_service.Service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("No such product found with ID: " + productId));
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse addProduct(ProductRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        Product product = productMapper.toEntity(request);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    public ProductResponse updateProduct(Long productId, ProductRequest request) {
        if (productRepository.existsById(productId)) {
            Product existingProduct = productRepository.findById(productId)
                    .orElseThrow(() -> new NoSuchElementException("No such product found with ID: " + productId));
            
            existingProduct.setName(request.getName());
            existingProduct.setDescription(request.getDescription());
            existingProduct.setPrice(request.getPrice());
    
            Set<Category> categories = productMapper.convertCategoryIdsToEntities(request.getCategories());
            existingProduct.setCategories(categories);
    
            existingProduct.setInventoryCount(request.getInventoryCount());
    
            return productMapper.toResponse(productRepository.save(existingProduct));
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        } else {
            throw new IllegalArgumentException("No product available with ID: " + productId);
        }
    }

    @Override
    public List<Product> filterByPrice(Double price) {
        return productRepository.findByPriceLessThanEqual(price);
    }

    @Override
    public List<ProductResponse> getProductsByCategory(Long categoryId) {
        List<Product> products = productRepository.findProductsByCategoryId(categoryId);
        return products.stream()
                       .map(productMapper::toResponse)
                       .collect(Collectors.toList());
    }

    @Override
    public List<Product> filterByInventory(Long minInventory) {
        return productRepository.findByInventoryCountGreaterThan(minInventory);
    }

}