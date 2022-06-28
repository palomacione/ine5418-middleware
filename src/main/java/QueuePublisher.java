import org.apache.camel.CamelContext;
import org.springframework.stereotype.Component;

@Component
public class QueuePublisher {

    public QueuePublisher(){}

    public void publishToQueue(String messageToBeSent, CamelContext camelContext) {
        camelContext.createProducerTemplate();
        var producer  = camelContext.createProducerTemplate();
        producer.sendBody("activemq:myQueue", messageToBeSent);
        // publish to queue
    }
}
