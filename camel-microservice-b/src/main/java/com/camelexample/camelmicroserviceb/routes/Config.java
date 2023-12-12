package com.camelexample.camelmicroserviceb.routes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties (prefix = "app")
public class Config {

    private String name;

    public boolean isUse () {
        return use;
    }

    public void setUse (boolean use) {
        this.use = use;
    }

    private boolean use;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
