package com.camelexample.camelmicroservicea.patterns;

import com.camelexample.camelmicroservicea.configs.ArrayListAggregationStrategy;
import com.camelexample.camelmicroservicea.configs.DynamicRouterBean;
import com.camelexample.camelmicroservicea.domain.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatternsRouter extends RouteBuilder {

    @Autowired
    private SplitterComponent splitterComponent;

    @Autowired
    private DynamicRouterBean dynamicRouterBean;

    @Override
    public void configure () throws Exception {

        errorHandler (deadLetterChannel ("activemq:dead-letter-queue"));

        //multicast pattern
        from ("timer:multicast?period=10000")
                .id ("Multicast-Route")
                .multicast ()
                .parallelProcessing ()
                .to ("log:route1", "log:route2", "log:route3");

        //splitter pattern
        from ("file:files/csv")
                .id ("CSV-Files-Input-Route")
                .unmarshal ().csv ()
                .log ("${body}")
                .split (method (splitterComponent, "splitInput"))
                .to ("activemq:split-queue");

        //aggregator pattern
        from ("file:files/aggregate-json")
                .id ("Aggregator-Files-Input-Route")
                .unmarshal ().json (JsonLibrary.Jackson, CurrencyExchange.class)
                .aggregate (constant (true), new ArrayListAggregationStrategy ())
                .completionSize (3)
                .convertBodyTo (String.class)
                //.completionTimeout (1000)
                .to ("activemq:aggregated-queue");
        //  .to ("log:aggregated-json-message");

        //routing slip
        String routingSlip = "direct:endpoint1,direct:endpoint2";
        String routingSlip1 = "direct:endpoint1,direct:endpoint2";

        from ("timer:routingSlip?period={{{app.timePeriod}}")
                .transform ().constant ("My message is Hardcoded")
                .routingSlip (simple (routingSlip));

        from ("direct:endpoint1")
                .to ("log:endpoint1");

        from ("direct:endpoint2")
                .to ("{{app.endpoint1}}");

        from ("direct:endpoint3")
                .wireTap ("log:wire-tap")
                .to ("log:endpoint3");

        //dynamic routing
        from("timer:routingSlip1?period=3000")
                .transform().constant("My message is Hardcoded")
                .dynamicRouter(method(dynamicRouterBean, "decideTheNextEndpoint"));




    }
}
