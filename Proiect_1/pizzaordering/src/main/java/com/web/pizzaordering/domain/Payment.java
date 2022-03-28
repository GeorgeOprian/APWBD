package com.web.pizzaordering.domain;

import com.web.pizzaordering.domain.types.PaymentMethod;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "PAYMENT_METHOD")
    private PaymentMethod paymentMethod;

    @Column(name = "AMOUNT")
    private Double amount;


}


