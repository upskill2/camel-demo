package com.camelexample.camelmicroserviceb.routes;

import com.camelexample.camelmicroserviceb.domain.CurrencyExchange;
import com.camelexample.camelmicroserviceb.configs.Config;
import com.camelexample.camelmicroserviceb.configs.MyCurrencyExchangeProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqXmlReceiverRouter extends RouteBuilder {

    @Autowired
    private MyCurrencyExchangeProcessor myCurrencyExchangeProcessor;

    @Value ("${app.use}")
    private boolean use;

    @Autowired
    private Config config;

    @Override
    public void configure () throws Exception {

        String queueName = config.getName ();

        from ("activemq:my-activemq-xml-queue")
                .unmarshal ()
                .jacksonXml (CurrencyExchange.class)
                .to ("log:received-message-from-active-mq");
    }
}
