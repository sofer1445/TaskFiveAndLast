public class ShoppingCart {
    private Inventory availableInventory;
    private Product[] availableProduct;

    public ShoppingCart(Inventory availableInventory, Product[] availableProduct) {
        this.availableInventory = availableInventory;
        this.availableProduct = availableProduct;
    }
}
