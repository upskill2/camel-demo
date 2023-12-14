package com.camelexample.camelmicroserviceb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class KafkaReceiverRouter extends RouteBuilder {

    @Override
    public void configure () throws Exception {

        from ("kafka:customKafkaTopic")
                .unmarshal ()
                .jacksonXml (CurrencyExchange.class)
                .to ("log:received-message-from-kafka");
    }
}
