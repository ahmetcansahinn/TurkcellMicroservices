package com.turkcell.product.service.controllers;

import com.turkcell.product.service.dto.request.CreateProductRequest;
import com.turkcell.product.service.dto.response.CreateProductResponse;
import com.turkcell.product.service.entities.Product;
import com.turkcell.product.service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request){
        return productService.add(request);
    }

    @GetMapping("check-stock")
    public Boolean getByInventoryCode(@RequestParam String invCode,
                                      @RequestParam int requiredStock){
        return productService.getByInventoryCode(invCode, requiredStock);
    }
}

