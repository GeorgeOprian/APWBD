package com.web.pizzaordering.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct implements Serializable {

    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;


    @Column(name = "QUANTITY")
    private Double quantity;

    @Column(name = "PRICE")
    private Double unitPrice;


}
