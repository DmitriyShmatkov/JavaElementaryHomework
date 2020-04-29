package homework20;

import java.util.ArrayList;
import java.util.List;

public class Workspace {

    private final int LOAD_COEFFICIENT = 5;

    private final List<Product> products;

    public Workspace() {
        products = new ArrayList<>();
    }

    public synchronized void addProduct(Product product) {
        products.add(product);
    }

    public synchronized Product get(int i) {
        return products.get(i);
    }

    public synchronized void removeProduct(Product product) {
        products.remove(product);
    }

    public synchronized boolean isEmpty() {
        return products.isEmpty();
    }

    public synchronized boolean isFull() {
        return products.size() >= LOAD_COEFFICIENT;
    }

    public synchronized int getProductsNumber() {
        return products.size();
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
