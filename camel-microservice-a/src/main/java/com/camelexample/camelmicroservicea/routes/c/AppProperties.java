package com.camelexample.camelmicroservicea.routes.c;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@ConfigurationProperties(prefix = "app")
@PropertySources ({
        @PropertySource ("camel-microservice-a/src/main/resources/application.yml") //application.yml
})
@Configuration
@Getter
@Setter
@ToString
public class AppProperties {

   private boolean sendToFile;
   private String queueName;

}
