package com.turkcell.order.service.business.abstracts;

import com.turkcell.order.service.dtos.CreateOrderRequest;

import java.util.List;

public interface OrderService {
    Boolean submitOrders(List<CreateOrderRequest> requests);
}
