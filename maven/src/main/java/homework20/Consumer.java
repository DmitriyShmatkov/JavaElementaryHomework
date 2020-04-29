package homework20;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Consumer implements Runnable {

    private List<Product> consumedProducts;
    private Workspace workspace;

    public Consumer(Workspace workspace) {
        this.workspace = workspace;
        consumedProducts = new ArrayList<>();
    }

    @Override
    public void run() {
        while (true) {
            int randomizer = (int) (Math.random() * 10 + 1);
            if (randomizer % 5 == 0) {
                while (true) {
                    System.out.println("\n\tCONSUMER >> Workspace: " + workspace);
                    if (!workspace.isEmpty()) {
                        consume();
                        break;
                    } else {
                        System.out.println("\n\tCONSUMER >> Workspace is empty. Waiting for 3 seconds");
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

    public void consume () {
        int i = (int) (Math.random() * workspace.getProductsNumber());
        Product consumedProduct = workspace.get(i);
        workspace.removeProduct(consumedProduct);
        consumedProducts.add(consumedProduct);
        System.out.println("\n\tCONSUMER >> Consumed product #" + (i + 1) + " from workspace");
        System.out.println("\n\tCONSUMER >> Workspace: " + workspace);
    }
}
