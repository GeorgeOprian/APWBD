package com.web.pizzaordering.domain;

import com.web.pizzaordering.domain.security.User;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "USER_ORDER")
@Table(name = "USER_ORDER")
@Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Order {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private OrderAddress address;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderProduct> products;

    public void addProduct(Product newProduct) {
        OrderProduct orderProduct = new OrderProduct(this, newProduct);
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(orderProduct);
    }

    public void removeProduct (Product product) {
        for (OrderProduct orderedProduct: products) {
            if (orderedProduct.getProduct().equals(product)) {
                products.remove(orderedProduct);
                orderedProduct.setProduct(null);
                orderedProduct.setOrder(null);
            }
        }
    }
}
