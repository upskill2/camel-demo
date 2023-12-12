package routes.a;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
@AllArgsConstructor
public class SimpleLoggingProcessor implements Processor {
   @Override
    public void process (final Exchange exchange) throws Exception {
        log.info ("SimpleLoggingProcessor {}", exchange.getMessage ().getBody ());

    }
}
