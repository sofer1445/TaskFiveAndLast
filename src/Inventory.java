import java.util.Arrays;

public class Inventory {
    private Product[] products;

    public Inventory(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
    

    @Override
    public String toString() {
        return "Inventory{ " +
                "products : " + "\n" + Arrays.toString(products) +
                '}';
    }
}
