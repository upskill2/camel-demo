package com.camelexample.camelmicroservicea;

import com.camelexample.camelmicroservicea.routes.a.TimeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CamelMicroserviceAApplication implements CommandLineRunner {

    @Autowired
    TimeComponent timeComponent;

    public static void main (String[] args) {
        SpringApplication.run (CamelMicroserviceAApplication.class, args);
    }

    @Override
    public void run (final String... args) throws Exception {

        log.info ("Current time: " + timeComponent.getCurrentTime ());
    }
}
