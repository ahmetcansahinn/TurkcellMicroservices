package com.turkcell.order.service.business.concrets;

import com.turkcell.order.service.business.abstracts.OrderService;
import com.turkcell.order.service.config.WebClientConfig;
import com.turkcell.order.service.dtos.CreateOrderRequest;
import com.turkcell.order.service.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public Boolean submitOrders(List<CreateOrderRequest> requests) {
        for (CreateOrderRequest request : requests) {

            Boolean hasStock = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8083/api/v1/products/check-stock",
                            (uriBuilder) -> uriBuilder
                                    .queryParam("invCode", request.getInventoryCode())
                                    .queryParam("requiredStock", request.getAmount())
                                    .build())
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
            if (!hasStock) {

                return false;
            }
        }
        return true;
    }
}


