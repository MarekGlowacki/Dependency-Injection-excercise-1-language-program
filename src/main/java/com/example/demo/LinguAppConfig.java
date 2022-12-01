package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
class LinguAppConfig {
    private final String decorator;

    LinguAppConfig(@Value("${app.message.decorator}") String decorator) {
        this.decorator = decorator;
    }

    void print(String message) {
        if (decorator.equals("UPPERCASE")) {
            System.out.println(message.toUpperCase());
        } else if (decorator.equals("LOWERCASE")) {
            System.out.println(message.toLowerCase());
        } else {
            throw new InvalidDecoratorException("No decorator found for " + decorator);
        }
    }
}
