package com.web.pizzaordering.confirguration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

public class MvcConfiguration implements WebMvcConfigurer {
    @Bean(name="simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver
    getSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r =
                new SimpleMappingExceptionResolver();

        r.setDefaultErrorView("error_default");
        r.setExceptionAttribute("ex");     // default "exception"

        Properties mappings = new Properties();
        mappings.setProperty("NumberFormatException", "numberformaterr");
        r.setExceptionMappings(mappings);

        Properties statusCodes = new Properties();
        statusCodes.setProperty("NumberFormatException", "400");
        r.setStatusCodes(statusCodes);


        return r;
    }

}