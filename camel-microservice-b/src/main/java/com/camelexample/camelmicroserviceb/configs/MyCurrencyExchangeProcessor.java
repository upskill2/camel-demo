package com.camelexample.camelmicroserviceb.configs;

import com.camelexample.camelmicroserviceb.domain.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class MyCurrencyExchangeProcessor {

    public void processMessage (CurrencyExchange currencyExchange) {
        log.info ("Do some processing with currencyExchange");
        currencyExchange.setConversionMultiple (
                currencyExchange.getConversionMultiple ().multiply (BigDecimal.TEN));
    }


}
