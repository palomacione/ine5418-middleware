import org.apache.camel.CamelContext;

import java.io.IOException;

public class QueuePublisher {

    public QueuePublisher(){}

    public void publishToQueue(String messageToBeSent, CamelContext camelContext) {
        camelContext.createProducerTemplate();
        try (var producer = camelContext.createProducerTemplate()) {
            producer.sendBody("activemq:myQueue", messageToBeSent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
