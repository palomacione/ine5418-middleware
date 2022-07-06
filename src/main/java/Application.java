import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        QueuePublisher queuePublisher = new QueuePublisher();
        QueueReceiver queueReceiver = new QueueReceiver();
        camelContext.addRoutes(queueReceiver);
        try {
            camelContext.start();
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String pedido = scanner.nextLine();
                if ("fim".equals(pedido)) {
                    camelContext.stop();
                    break;
                } else {
                    queuePublisher.publishToQueue(pedido, camelContext);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
