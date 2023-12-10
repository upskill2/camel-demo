package com.camelexample.camelmicroservicea.routes.a;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class SimpleLoggingComponent {

    private final Logger logger = LoggerFactory.getLogger (SimpleLoggingComponent.class.getName ());

    public void process (final String message) {
        logger.info ("SimpleLoggingComponent {}", message);
    }


}
