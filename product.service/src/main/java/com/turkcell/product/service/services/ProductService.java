package com.turkcell.product.service.services;

import com.turkcell.product.service.dto.request.CreateProductRequest;
import com.turkcell.product.service.dto.response.CreateProductResponse;
import com.turkcell.product.service.entities.Product;

public interface ProductService {
    CreateProductResponse add(CreateProductRequest request);
    Boolean getByInventoryCode(String code, int requiredStock);
}

