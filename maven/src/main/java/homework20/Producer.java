package homework20;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producer implements Runnable {

    private Workspace workspace;

    public Producer(Workspace workspace) {
        this.workspace = workspace;
    }

    @Override
    public void run() {
        while (true) {
            int randomizer = (int) (Math.random() * 10 + 1);
            if (randomizer % 5 == 0) {
                while (true) {
                    System.out.println("\nPRODUCER >> Workspace: " + workspace);
                    if (!workspace.isFull()) {
                        produce();
                        break;
                    } else {
                        System.out.println("\nPRODUCER >> Workspace is full. Waiting for 3 seconds");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void produce() {
        System.out.println("\nPRODUCER >> Starting producing new product");

        int timeForProducing = (int) (Math.random() * 1500 + 1000);
        try {
            Thread.sleep(timeForProducing);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Product producedProduct = new Product((int) (Math.random() * 100));
        workspace.addProduct(producedProduct);

        System.out.println("\nPRODUCER >> Produced product: " + producedProduct);
        System.out.println("\nPRODUCER >> Added product to workspace");
        System.out.println("\nPRODUCER >> Workspace: " + workspace);
    }
}
