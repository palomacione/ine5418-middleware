import org.apache.camel.builder.RouteBuilder;

import java.util.Random;

public class QueueReceiver extends RouteBuilder {

    @Override
    public void configure() {
        this.fromF("activemq:myQueue?concurrentConsumers=2").routeId("Hamburgueria - Quebra Gelo")
                .process(exchange -> this.processPublishingObject(exchange.getIn().getBody(String.class)));
    }

    private void processPublishingObject(String message) throws InterruptedException {
        log.info("Seu pedido foi recebido: {}", message);
        log.info("Produzindo {} ... ", message);
        Random random = new Random();
        var tempoDePreparo = random.ints(5000, 10000).findFirst().getAsInt();
        Thread.sleep(tempoDePreparo);
        log.info("Seu pedido está pronto: {}", message);
    }

}
