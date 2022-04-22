package com.web.pizzaordering.controller;

import com.web.pizzaordering.Exceptions.InternalServerError;
import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private ProductService service;

    @GetMapping
    public String getProducts(Model model) {

        List<Product> pizzas = service.loadPizzas();
        model.addAttribute("pizzas", pizzas);

        List<Product> drinks = service.loadDrinks();
        model.addAttribute("drinks", drinks);

        return "menu";
    }

    @GetMapping("products/add_product/new")
    public String addProductForm(Model model) {

        model.addAttribute("product", new Product());
        return "add_product_form";
    }

    @PostMapping("products/add_product")
    public String addProduct(@Valid @ModelAttribute Product receivedProduct,
                             BindingResult bindingResult,
                            @NotNull @RequestParam("imagefile")MultipartFile image) {

        if (bindingResult.hasErrors()) {
            return "add_product_form";
        }

        Product saved = service.addProduct(receivedProduct);
        service.saveImage(saved.getProductId(), image);

        return "redirect:/menu";
    }

    //TODO GET update product form + POST update product


}
