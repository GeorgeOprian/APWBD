package com.web.pizzaordering.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ORDER_ADDRESS")
public class OrderAddress implements Serializable {


    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @NotNull(message = "this field is required")
    @Size(max = 50, message = "Max size is 50")
    @Column(name = "CITY")
    private String city;

    @NotNull(message = "this field is required")
    @Size(max = 100, message = "Max size is 100")
    @Column(name = "STREET")
    private String street;

    @NotNull(message = "this field is required")
    @Positive
    @Column(name = "NUMBER")
    private Integer number;

}
