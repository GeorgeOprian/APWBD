package com.web.pizzaordering.domain;

import com.web.pizzaordering.domain.types.ProductTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.validation.constraints.*;

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

    @NotNull(message = "this field is required")
    @NotEmpty(message = "must not be empty")
    @NotBlank(message = "must not be blank")
    @Size(max = 100)
    @Column(name = "NAME")
    private String productName;

    @NotNull(message = "this field is required")
    @Positive(message = "Must be positive")
    @Column(name = "QUANTITY")
    private Double quantity;

    @NotNull(message = "this field is required")
    @Positive(message = "Must be positive")
    @Column(name = "UNIT_PRICE")
    private Double unitPrice;

    @Column(name = "INGREDIENTS")
    private String ingredients;

    @NotNull(message = "this field cannot be null")
    @Column(name = "PRODUCT_TYPE")
    @Enumerated(EnumType.STRING)
    private ProductTypes productType;

    @OneToOne(mappedBy = "product",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductImage image;

}
