package com.web.pizzaordering.controller;

import com.web.pizzaordering.domain.security.User;

import com.web.pizzaordering.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
//        List<User> users = userRepository.findAll();
//
//        for (User user: users) {
//            List<Order> orders = user.getOrders();
//
//            for (Order order: orders) {
//                List<OrderProduct> products = order.getProducts();
//                System.out.println();
//            }
//        }

        User user = userRepository.findById(1).get();
        return new ResponseEntity(Arrays.asList(user), HttpStatus.OK);

    }
}
