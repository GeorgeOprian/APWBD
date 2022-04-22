package com.web.pizzaordering.services;

import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.domain.types.ProductTypes;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {

    Product findById(Integer id);

    List<Product> loadAllProducts();

    List<Product> loadPizzas();

    List<Product> loadDrinks();

    Product addProduct(Product product);

    void saveImage(Integer productId, MultipartFile image);

    void deleteProduct(Integer productId);
}
