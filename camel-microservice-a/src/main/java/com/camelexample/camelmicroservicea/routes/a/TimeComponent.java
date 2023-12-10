package com.camelexample.camelmicroservicea.routes.a;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
public class TimeComponent {

    public String getCurrentTime(){
        return LocalDateTime.now().toString ();
    }
}
