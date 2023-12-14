package com.camelexample.camelmicroservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages ="")
public class CamelMicroserviceAApplication {

    public static void main (String[] args) {
        SpringApplication.run (CamelMicroserviceAApplication.class, args);
    }
}
