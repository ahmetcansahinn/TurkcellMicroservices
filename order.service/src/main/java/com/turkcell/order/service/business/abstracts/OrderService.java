package com.turkcell.order.service.business.abstracts;

import com.turkcell.order.service.dtos.CreateOrderRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {

    Boolean submitOrdersnew(List<CreateOrderRequest> requests);

}
