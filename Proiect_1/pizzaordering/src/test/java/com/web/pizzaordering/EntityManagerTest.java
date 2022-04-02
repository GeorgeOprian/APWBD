package com.web.pizzaordering;


import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("h2")
@Rollback(false)
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void findUser() {
        User userFound = entityManager.find(User.class, 1);
        assertEquals(userFound.getUserName(), "georgeOprian");
    }

    @Test
    public void findProduct() {
        Product productFound = entityManager.find(Product.class, 1);
        assertEquals(productFound.getProductName(), "beer");
    }

}
