package com.turkcell.order.service.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderRequest {
    private String inventoryCode;
    private Integer amount;
}
