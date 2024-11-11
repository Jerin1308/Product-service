package com.onlineShopping.Product_service.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.onlineShopping.Product_service.Exception.ResourceNotFoundException;
import com.onlineShopping.Product_service.Model.Category;
import com.onlineShopping.Product_service.Repository.CategoryRepository;
import com.onlineShopping.Product_service.Service.CategoryService;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }
    
}
