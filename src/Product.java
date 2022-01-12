public class Product {
    private String productDescription;
    private int price;
    private int discountPercentage;
    private int numberOfProduct;

    public Product(String productDescription, int price, int discountPercentage , int numberOfProduct) {
        this.productDescription = productDescription;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.numberOfProduct = numberOfProduct;

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

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    @Override
    public String toString() {
        return  productDescription + '\'' +
                ", price=" + price +
                ", numberOfProduct=" + numberOfProduct +
                '}';
    }
}
