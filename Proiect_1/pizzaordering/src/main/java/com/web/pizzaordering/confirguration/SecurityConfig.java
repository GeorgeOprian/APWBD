package com.web.pizzaordering.confirguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Profile("mysql")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("GUEST","ADMIN")
                .antMatchers("/menu").hasAnyRole("GUEST","ADMIN")
                .antMatchers("/menu/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/loginForm")
                .loginProcessingUrl("/authUser")
                .failureUrl("/loginForm").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");
    }

}