package com.web.pizzaordering.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "PRODUCT")
@Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "NAME")
    private String productName;

    @Column(name = "QUANTITY")
    private Double quantity;

    @Column(name = "UNIT_PRICE")
    private Double unitPrice;

    @Column(name = "INGREDIENTS")
    private String ingredients;

}
