package com.camelexample.camelmicroserviceb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMaReceiverRouter extends RouteBuilder {
    @Override
    public void configure () throws Exception {

                from ("activemq:my-activemq-queue")
                        .log ("${body}")
                        .to ("log:received-message-from-active-mq");
    }
}
