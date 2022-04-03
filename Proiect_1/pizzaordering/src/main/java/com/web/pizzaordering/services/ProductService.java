package com.web.pizzaordering.services;

import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.domain.types.ProductTypes;
import com.web.pizzaordering.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> loadAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> loadPizzas() {
        return productRepository.findByType(ProductTypes.PIZZA);
    }

    @Override
    public List<Product> loadDrinks() {
        return productRepository.findByType(ProductTypes.DRINK);
    }

    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return null;
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
