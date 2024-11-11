package com.onlineShopping.Product_service.Response;

import lombok.AllArgsConstructor;

import java.util.Set;

import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Set<Long> categories;
    private Long inventoryCount;

}

