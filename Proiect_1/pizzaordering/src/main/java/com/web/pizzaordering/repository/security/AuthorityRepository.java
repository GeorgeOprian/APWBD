package com.web.pizzaordering.repository.security;


import com.web.pizzaordering.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
