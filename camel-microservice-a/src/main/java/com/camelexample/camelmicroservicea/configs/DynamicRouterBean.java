package com.camelexample.camelmicroservicea.configs;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
@Slf4j
public class DynamicRouterBean {

    public String decideTheNextEndpoint (@ExchangeProperties Map<String, String> properties,
                                         @Headers String body) {
        String nextEndpoint = null;
        if (body.contains ("USD")) {
            nextEndpoint = "direct:endpoint1";
        } else if (body.contains ("EUR")) {
            nextEndpoint = "direct:endpoint2";
        } else if (body.contains ("INR")) {
            nextEndpoint = "direct:endpoint3";
        } else if (body.contains ("GBP")) {
            nextEndpoint = "direct:endpoint1";
        }
        return nextEndpoint;
    }
}
