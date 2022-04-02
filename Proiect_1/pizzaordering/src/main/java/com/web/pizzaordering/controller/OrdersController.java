package com.web.pizzaordering.controller;

import com.web.pizzaordering.domain.Order;
import com.web.pizzaordering.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping
    public ResponseEntity<Order> getOrders() {
        List<Order> orders = ordersRepository.findAll();

        return new ResponseEntity<>(orders.get(0), HttpStatus.OK);
    }
}
