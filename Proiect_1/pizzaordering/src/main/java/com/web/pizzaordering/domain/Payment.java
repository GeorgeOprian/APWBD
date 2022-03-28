package com.web.pizzaordering.domain;

import com.web.pizzaordering.domain.types.PaymentMethod;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private UserOrder order;

    @Column(name = "PAYMENT_METHOD")
    private PaymentMethod paymentMethod;

    @Column(name = "AMOUNT")
    private Double amount;



}


