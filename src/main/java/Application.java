import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Application {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        QueuePublisher queuePublisher = new QueuePublisher();
        QueueReceiver queueReceiver = new QueueReceiver();
        camelContext.addRoutes(queueReceiver);
        try {
            camelContext.start();
            queuePublisher.publishToQueue("Hi queue", camelContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
