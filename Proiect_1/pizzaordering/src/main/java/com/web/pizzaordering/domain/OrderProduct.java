package com.web.pizzaordering.domain;

import com.web.pizzaordering.domain.primarykeys.OrderProductId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct implements Serializable {

    @EmbeddedId
    private OrderProductId id;

    @NotNull(message = "this field is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @NotNull(message = "this field is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull(message = "this field is required")
    @Positive(message = "Must be positive")
    @Column(name = "QUANTITY")
    private Double quantity;

    @NotNull(message = "this field is required")
    @Positive(message = "Must be positive")
    @Column(name = "PRICE")
    private Double price;

    public OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
