import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class QueueReceiver extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        this.fromF("activemq:myQueue").routeId("MultiplierQueue")
                .process(exchange -> this.processPublishingObject(exchange.getMessage(String.class)));
    }

    private void processPublishingObject(String message) {
    }

}
