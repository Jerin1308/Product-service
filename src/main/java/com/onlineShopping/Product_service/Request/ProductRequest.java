package com.onlineShopping.Product_service.Request;

import java.util.Set;

import lombok.Data;

import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductRequest {

    private String name;
    private String description;
    private Double price;
    private Set<Long> categories;
    private Long inventoryCount;
    
}

