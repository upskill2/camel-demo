package com.camelexample.camelmicroserviceb.configs;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TrustedPackagesConfig {

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        factory.setTrustedPackages(Arrays.asList("com.camelexample.camelmicroserviceb", "java.util"));
        return factory;
    }

}
