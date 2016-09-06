package com.simpleCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by jpierce on 9/3/16.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.simpleCrud")
public class Application {

    // This is the entry point for the Spring Boot application
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
