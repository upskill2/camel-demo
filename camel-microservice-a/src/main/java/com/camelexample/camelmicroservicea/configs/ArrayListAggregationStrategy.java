package com.camelexample.camelmicroservicea.configs;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListAggregationStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate (final Exchange oldExchange, final Exchange newExchange) {
        Object newBody = newExchange.getIn ().getBody ();
        ArrayList<Object> list = null;

        if (oldExchange == null) {
            list = new ArrayList<Object> ();
            list.add (newBody);
            newExchange.getIn ().setBody (list);
            return newExchange;
        } else {
            list = oldExchange.getIn ().getBody (ArrayList.class);
            list.add (newBody);
            return oldExchange;
        }

    }
}
