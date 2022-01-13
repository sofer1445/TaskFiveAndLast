import java.util.Arrays;

public class ShoppingCart {
    private Inventory availableInventory;
    private Product[] availableProduct;

    public ShoppingCart(Inventory availableInventory, Product[] availableProduct) {
        this.availableInventory = availableInventory;
        this.availableProduct = availableProduct;
    }

    public Inventory getAvailableInventory() {
        return availableInventory;
    }

    public void setAvailableInventory(Inventory availableInventory) {
        this.availableInventory = availableInventory;
    }

    public Product[] getAvailableProduct() {
        return availableProduct;
    }

    public void setAvailableProduct(Product[] availableProduct) {
        this.availableProduct = availableProduct;
    }

    @Override
    public String toString() {
        return "ShoppingCart : " +
                  Arrays.toString(availableProduct) +
                '}';
    }
}
