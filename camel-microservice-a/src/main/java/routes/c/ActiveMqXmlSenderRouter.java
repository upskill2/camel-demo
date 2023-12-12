package routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqXmlSenderRouter extends RouteBuilder {
    @Value ("${app.configs.send-files}")
    private boolean sendFile;

    @Override
    public void configure () throws Exception {
        from ("file:files/xlm")
                .log ("${body}")
                .to ("activemq:my-activemq-xml-queue");
    }

}

