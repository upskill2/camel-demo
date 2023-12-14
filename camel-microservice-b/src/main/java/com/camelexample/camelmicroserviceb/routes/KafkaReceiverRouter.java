package com.camelexample.camelmicroserviceb.routes;

import com.camelexample.camelmicroserviceb.domain.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;

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
