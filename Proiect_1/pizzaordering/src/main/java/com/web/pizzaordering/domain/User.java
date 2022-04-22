package com.web.pizzaordering.domain;

import com.web.pizzaordering.domain.types.UserTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "APP_USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull(message = "this field is required")
    @Size(min = 5, max = 100)
    @Column(name = "USER_NAME")
    private String userName;

    @NotNull(message = "this field is required")
    @Size(min = 8)
    @Column(name = "PASSWORD")
    private String password;

    @NotNull(message = "this field is required")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull(message = "this field is required")
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull(message = "this field is required")
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @NotNull(message = "this field is required")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private UserTypes userType;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;


}
