package com.camelexample.camelmicroservicea.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class FirstTimerRouter extends RouteBuilder {

    @Autowired
    private TimeComponent timeComponent;

    @Autowired
    private SimpleLoggingComponent loggingComponent;

    @Override
    public void configure () throws Exception {

        from ("timer:first-timer")
                .log ("${body}")
                .transform ().constant ("My Constant Message")
                .log ("${body}")
                .bean (timeComponent, "getCurrentTime")
                .log ("${body}")
                .bean (loggingComponent)
                .process (new SimpleLoggingProcessor ())
                .log ("${body}")
                .to ("log:first-timer");

    }
}
