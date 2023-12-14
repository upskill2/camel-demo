package routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RestApiConsumerRouter extends RouteBuilder {
    @Override
    public void configure () throws Exception {
        restConfiguration ()
                .host ("localhost")
                .port (8000);

        from ("timer:rest-api-consumer?period=10000")
                .setHeader ("from", () -> "USD")
                .setHeader ("to", () -> "EUR")
/*                .setHeader ("Content-Type", () -> "application/json")
                .setHeader ("Accept", () -> "application/json")
                .setHeader ("Accept-Encoding", () -> "gzip, deflate, br")
                .setHeader ("Connection", () -> "keep-alive")
                .setHeader ("Host", () -> "localhost:8080")
                .setHeader ("User-Agent", () -> "PostmanRuntime/7.26.8")
                .setHeader ("Postman-Token", () -> "b9b7b9a3-9b7a-4b7a-8b7a-7b9b7b9b7b9b")
                .setHeader ("Accept-Language", () -> "en-US,en;q=0.5")*/
                .to ("rest:get:/currency-exchange/from/${from}/to/{to}")
                .log ("${body}");
    }
}
