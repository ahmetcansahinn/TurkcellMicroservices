package com.turkcell.order.service.repositories;

import com.turkcell.order.service.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
