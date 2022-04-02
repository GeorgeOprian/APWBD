package com.web.pizzaordering.repository;

import com.web.pizzaordering.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}