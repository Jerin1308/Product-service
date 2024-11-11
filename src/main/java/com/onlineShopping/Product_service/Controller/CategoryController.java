package com.onlineShopping.Product_service.Controller;

import org.springframework.web.bind.annotation.*;

import com.onlineShopping.Product_service.Model.Category;
import com.onlineShopping.Product_service.Service.ServiceImpl.CategoryServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/")
    public List<Category> getAllCategories() {
        return categoryServiceImpl.getAllCategories();
    }

    @PostMapping("/")
    public Category addCategory(@RequestBody Category category) {
        return categoryServiceImpl.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        return categoryServiceImpl.updateCategory(id, categoryDetails);
    }
}