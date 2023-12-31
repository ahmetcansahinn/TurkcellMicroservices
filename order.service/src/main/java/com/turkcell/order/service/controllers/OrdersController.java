package com.turkcell.order.service.controllers;

import com.turkcell.order.service.business.abstracts.OrderService;
import com.turkcell.order.service.dtos.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RequestMapping("api/v1/orders")
@RestController
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;

    private final WebClient.Builder webClientBuilder;
    @PostMapping
    public ResponseEntity<Boolean> submitOrders(@RequestBody List<CreateOrderRequest> requests) {
        Boolean allStockAvailable = orderService.submitOrdersnew(requests);

        if (allStockAvailable) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}




