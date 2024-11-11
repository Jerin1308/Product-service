package com.onlineShopping.Product_service.Mapper;

import com.onlineShopping.Product_service.Model.Category;
import com.onlineShopping.Product_service.Model.Product;
import com.onlineShopping.Product_service.Request.ProductRequest;
import com.onlineShopping.Product_service.Response.ProductResponse;
import com.onlineShopping.Product_service.Repository.CategoryRepository; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductMapper {

    @Autowired
    private CategoryRepository categoryRepository; 

    public Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategories(convertCategoryIdsToEntities(request.getCategories())); 
        product.setInventoryCount(request.getInventoryCount());
        return product;
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            convertCategoryEntitiesToIds(product.getCategories()),
            product.getInventoryCount()
        );
    }
   
    public Set<Category> convertCategoryIdsToEntities(Set<Long> categoryIds) {
        Set<Category> categories = new HashSet<>();
        
        if (categoryIds != null && !categoryIds.isEmpty()) {
            List<Category> foundCategories = categoryRepository.findAllById(categoryIds);
            categories.addAll(foundCategories);
        }
        
        return categories;
    }

    public Set<Long> convertCategoryEntitiesToIds(Set<Category> categories) {
        Set<Long> categoryIds = new HashSet<>();
        for (Category category : categories) {
            categoryIds.add(category.getId());
        }
        return categoryIds;
    }
}