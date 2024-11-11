package com.onlineShopping.Product_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlineShopping.Product_service.Model.Category;
import com.onlineShopping.Product_service.Model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategories(Category category);

    List<Product> findByPriceLessThanEqual(Double price);
    
    List<Product> findByInventoryCountGreaterThan(Long count);

    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.id = :categoryId")
    List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);

}
