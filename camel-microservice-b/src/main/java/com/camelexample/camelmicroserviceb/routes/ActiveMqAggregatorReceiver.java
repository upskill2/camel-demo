package com.camelexample.camelmicroserviceb.routes;

import com.camelexample.camelmicroserviceb.domain.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqAggregatorReceiver extends RouteBuilder {

    @Override
    public void configure () throws Exception {

        from ("activemq:aggregated-queue")
                .unmarshal ()
                .json (JsonLibrary.Jackson, CurrencyExchange.class)
                .log ("${body}")
                .to ("log:received-message-from-aggregated-queue");

    }
}
