package com.web.pizzaordering.controller;

import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService service;

    @GetMapping("menu")
    public String getProducts(Model model) {

        List<Product> pizzas = service.loadPizzas();

        model.addAttribute("pizzas", pizzas);

        List<Product> drinks = service.loadDrinks();

        model.addAttribute("drinks", drinks);

        return "menu";
    }

    @PostMapping("add_pizza")
    public String addPizza() {
        return "add_pizza_form";
    }

    @PostMapping("add_drink")
    public String addDrink() {
        return "add_drink_form";
    }

}
