package com.web.pizzaordering.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ORDER_ADDRESS")
public class OrderAddress {

    @Id
//    @Column(name =  "order_id")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    private int orderId;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER")
    private Integer number;

}
