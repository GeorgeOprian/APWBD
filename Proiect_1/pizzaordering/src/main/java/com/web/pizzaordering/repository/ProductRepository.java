package com.web.pizzaordering.repository;

import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.domain.types.ProductTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select prod from Product prod where prod.productType = ?1")
    List<Product> findByType(ProductTypes productType);



}
