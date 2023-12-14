package com.camelexample.camelmicroserviceb.routes;

import com.camelexample.camelmicroserviceb.configs.MyCurrencyExchangeProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSplitFilesReceiverRouter extends RouteBuilder {

    @Autowired
    private MyCurrencyExchangeProcessor myCurrencyExchangeProcessor;


    @Override
    public void configure () throws Exception {

        from ("activemq:split-queue")
                .log ("${body}")
                .to ("activemq:received-message-from-split-queue");
    }
}
