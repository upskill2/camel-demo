package routes.b;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class DeciderBean {

    public boolean isThisConditionMet (@Body String body, @Headers Map<String, String> headers,
                                       @ExchangeProperties Map<String, String> exchangeProperties) {
        log.info ("body is: {}, headers are: {} , exchange are: {}", body, headers, exchangeProperties);
        return body.contains ("USD");
    }
}
