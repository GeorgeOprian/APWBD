package com.web.pizzaordering.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER_ORDER")
public class UserOrder {

    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "APP_USER_ID")
    private Integer userId;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OrderAddress address;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AppUser user;
}
