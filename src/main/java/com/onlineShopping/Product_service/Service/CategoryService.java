package com.onlineShopping.Product_service.Service;

import java.util.List;

import com.onlineShopping.Product_service.Model.Category;

public interface CategoryService {

    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(Long id, Category categoryDetails);

}
