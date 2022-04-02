package com.web.pizzaordering.domain.primarykeys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class OrderProductId implements Serializable {

    @Column(name = "ORDER_ID")
    private Integer orderId;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

}
