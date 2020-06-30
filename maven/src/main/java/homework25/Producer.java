package homework25;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    private static final String QUEUE_NAME = "MyQueue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        int messageNumber = 25;
        for (int i = 0; i < messageNumber; i++) {
            int rand = (int) (Math.random() * 5);
            Product producedProduct = Product.values()[rand];
            channel.basicPublish("", QUEUE_NAME, null, producedProduct.toString().getBytes());
            System.out.println("Produced: " + producedProduct);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        channel.close();
        connection.close();
    }
}
