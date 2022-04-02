package com.web.pizzaordering.repository;

import com.web.pizzaordering.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
