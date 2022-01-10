public class Product {
    private String productDescription;
    private int price;
    private int discountPercentage;

    public Product(String productDescription, int price, int discountPercentage) {
        this.productDescription = productDescription;
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
