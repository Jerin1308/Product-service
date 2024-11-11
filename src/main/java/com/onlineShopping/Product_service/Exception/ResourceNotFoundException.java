package com.onlineShopping.Product_service.Exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String string) {
        super("Resource not found");
    }

}
