package routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {

    @Autowired
    private DeciderBean deciderBean;
    @Override
    public void configure () throws Exception {

        from ("file:files/input")
                .pipeline ()
                .routeId ("Files-Input-Route")
                .transform ().body (String.class)
                .choice ()
                    .when (simple ("${file:ext} == 'xml'"))
                       .log ("XML FILE")
            //        .when(simple ("${body} contains 'USD'"))
                .when(method("deciderBean", "isThisConditionMet"))
                        .log ("Not XML FILE But USD")
                    .otherwise ()
                        .log ("Not an XML FILE")
                .end ()
                .log ("${body}")
                .log ("${messageHistory} ${file:absolute.path}")
                .to ("direct:log-file-values")
                .to ("file:files/output");

            from("direct:log-file-values")
                .routeId("Log-File-Values-Route")
                .log("File Name is ${header.CamelFileName} and File Absolute Path is ${header.CamelFileAbsolutePath}");
    }

}
