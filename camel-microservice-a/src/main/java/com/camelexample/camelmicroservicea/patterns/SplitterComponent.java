package com.camelexample.camelmicroservicea.patterns;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SplitterComponent {


    public List<String> splitInput (String body) {
        return Arrays.asList (body.split (","));
    }

}
