package com.turkcell.product.service.controllers;

import com.turkcell.product.service.dto.request.CreateProductRequest;
import com.turkcell.product.service.dto.request.CreateProductRequest;
import com.turkcell.product.service.dto.response.CreateProductResponse;
import com.turkcell.product.service.dto.response.CreateProductResponse;
import com.turkcell.product.service.entities.Product;
import com.turkcell.product.service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;
    private final KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request){
        return productService.add(request);
    }

    @GetMapping("check-stock")
    public Boolean getByInventoryCode(@RequestParam String invCode,
                                      @RequestParam int requiredStock){
        kafkaTemplate.send("notificationTopic","Sipariş verildi..");
        return productService.getByInventoryCode(invCode, requiredStock);
    }

    @GetMapping("deneme")
    public String deneme(){
        return "Deneme";
    }
}

