package com.camelexample.camelmicroservicea.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {

  @Value ("${app.configs.send-files}")
  private boolean sendFile;

    @Override
    public void configure () throws Exception {


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

