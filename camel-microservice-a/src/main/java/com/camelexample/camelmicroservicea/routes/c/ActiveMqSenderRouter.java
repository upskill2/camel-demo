package com.camelexample.camelmicroservicea.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {
/*    @Value ("${app.send-to-file}")
    private boolean sendToFile;*/


    private final AppProperties appProperties;

    public ActiveMqSenderRouter (AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public void configure () throws Exception {

        final boolean sendFile = appProperties.isSendToFile ();
        if (sendFile) {
            from ("file:files/json")
                    .log ("${body}")
                    .to ("activemq:my-activemq-queue");
        } else {
            from ("timer:active-mq-timer?period=10000")
                    .transform ().constant ("My Constant Message for Active MQ")
                    .log ("${body}")
                    .to ("activemq:my-activemq-queue");
        }


    }
}

