package com.web.pizzaordering.services;

import com.web.pizzaordering.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProductService {

    Product findById(Integer id);

    List<Product> loadAllProducts();

    List<Product> loadPizzas();

    List<Product> loadDrinks();

    Page<Product> loadPagedPizzas(Pageable page);

    Page<Product> loadPagedDrinks(Pageable page);

    Product saveProduct(Product product);

    void saveImage(Integer productId, MultipartFile image);

    void deleteProduct(Integer productId);
}
