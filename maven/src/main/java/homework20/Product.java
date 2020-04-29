package homework20;

public class Product {
    private Integer id;

    public Product(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
