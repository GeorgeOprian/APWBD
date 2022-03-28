package com.web.pizzaordering.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "QUANTITY")
    private Double quantity;

    @Column(name = "UNIT_PRICE")
    private Double unitPrice;

    @Column(name = "INGREDIENTS")
    private String ingredients;
}
