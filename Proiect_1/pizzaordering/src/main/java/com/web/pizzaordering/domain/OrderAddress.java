package com.web.pizzaordering.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ORDER_ADDRESS")
public class OrderAddress implements Serializable {


    @Id
//    @Column(name =  "order_id")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private UserOrder order;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER")
    private Integer number;

}
