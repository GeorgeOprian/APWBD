package com.web.pizzaordering.domain;

import com.web.pizzaordering.domain.primarykeys.OrderProductId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct implements Serializable {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "QUANTITY")
    private Double quantity;

    @Column(name = "PRICE")
    private Double unitPrice;

    public OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
