package com.camelexample.camelmicroservicea.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class KafkaSenderRouter extends RouteBuilder {

    @Override
    public void configure () throws Exception {
        from ("file:files/json_kafka")
                .log ("${body}")
                .to ("kafka:customKafkaTopic");
    }
}

