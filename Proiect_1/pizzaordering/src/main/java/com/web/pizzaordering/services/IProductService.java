package com.web.pizzaordering.services;

import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.domain.types.ProductTypes;

import java.util.List;

public interface IProductService {

    List<Product> loadAllProducts();

    List<Product> loadPizzas();

    List<Product> loadDrinks();

    Product addProduct(Product product);

    void deleteProduct(Integer productId);
}
