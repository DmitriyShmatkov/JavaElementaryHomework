package homework20;

public class Main {
    public static void main(String[] args) {

        Workspace workspace = new Workspace();

        Thread producer = new Thread(new Producer(workspace));
        Thread consumer = new Thread(new Consumer(workspace));

        producer.start();
        consumer.start();
    }
}
