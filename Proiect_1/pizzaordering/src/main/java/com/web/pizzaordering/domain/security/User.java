package com.web.pizzaordering.domain.security;

import com.web.pizzaordering.domain.Order;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
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

    @Singular
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name="authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities;


    @Builder.Default
    private Boolean enabled = true;

    @Builder.Default
    private Boolean accountNotExpired = true;

    @Builder.Default
    private Boolean accountNotLocked = true;

    @Builder.Default
    private Boolean credentialsNotExpired = true;

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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

}
