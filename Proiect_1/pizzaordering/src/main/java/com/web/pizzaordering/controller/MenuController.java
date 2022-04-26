package com.web.pizzaordering.controller;

import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    @Autowired
    private ProductService service;

    @GetMapping
    public String getProducts(Model model) {

        log.info("New request to /menu");
        log.info("New request to /menu");
        Page<Product> pizzas = service.loadPagedPizzas(PageRequest.of(Integer.valueOf(0), 3));
        if (!pizzas.getContent().isEmpty()) {
            model.addAttribute("pizzas", pizzas.getContent());
        }

        Page<Product> drinks = service.loadPagedDrinks(PageRequest.of(Integer.valueOf(0), 3));
        if (!drinks.getContent().isEmpty()) {
            model.addAttribute("drinks", drinks.getContent());
        }
        return "menu";
    }

    @GetMapping ("/{pageNumber}")
    public String getProducts(Model model, @PathVariable String pageNumber){
        log.info("New request to /menu");
        Page<Product> pizzas = service.loadPagedPizzas(PageRequest.of(Integer.valueOf(pageNumber), 3));
        if (!pizzas.getContent().isEmpty()) {
            model.addAttribute("pizzas", pizzas.getContent());
        }

        Page<Product> drinks = service.loadPagedDrinks(PageRequest.of(Integer.valueOf(pageNumber), 3));
        if (!drinks.getContent().isEmpty()) {
            model.addAttribute("drinks", drinks.getContent());
        }
        return "menu";
    }


    @GetMapping("products/add_product/new")
    public String addProductForm(Model model) {
        log.info("New request to /menu/products/add_product/new");
        model.addAttribute("product", new Product());
        return "add_product_form";
    }

    @PostMapping("products/add_product")
    public String addProduct(@Valid @ModelAttribute Product receivedProduct,
                             BindingResult bindingResult,
                            @NotNull @RequestParam("imagefile")MultipartFile image) {

        log.info("New request to /menu/products/add_product");
        if (bindingResult.hasErrors()) {
            return "add_product_form";
        }

        Product saved = service.saveProduct(receivedProduct);
        service.saveImage(saved.getProductId(), image);

        return "redirect:/menu";
    }

    @GetMapping("products/update_product/{id}")
    public String updateProductForm(Model model, @PathVariable String id) { // TODO change -> used only for authorisation testing


        log.info("New GET request to /menu/products/update_product/{id}");
        Product existentProduct = service.findById(Integer.valueOf(id));

        model.addAttribute("product", existentProduct);
        return "update_product_form";
    }

    @PostMapping("/products/update_product")
    public String updateProduct(@Valid @ModelAttribute Product product,
                               BindingResult bindingResult
    ){
        log.info("New PUT request to /menu/products/update_product/{id}");
        if (bindingResult.hasErrors()){
            return "update_product_form";
        }

        Product currentProduct = service.findById(product.getProductId());
        product.setImage(currentProduct.getImage());

        service.saveProduct(product);

        return "redirect:/menu" ;
    }

    @RequestMapping("products/delete_product/{id}")
    public String deleteProduct(@PathVariable String id) { // TODO change -> should return a DELETED http status
        service.deleteProduct(Integer.valueOf(id));
        return "redirect:/menu";
    }


}
