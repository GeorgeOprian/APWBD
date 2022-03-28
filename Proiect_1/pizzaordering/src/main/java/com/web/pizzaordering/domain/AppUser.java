package com.web.pizzaordering.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "APP_USER")
public class AppUser {

    @Id
    @Column(name = "USER_ID")
//    @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @OneToMany(mappedBy = "user")
    private List<UserOrder> orders;


}
