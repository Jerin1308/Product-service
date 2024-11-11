package com.onlineShopping.Product_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineShopping.Product_service.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
