public class Product {
    private String productDescription;
    private int price;
    private int discountPercentage;
    private int numberOfProduct;
    private  int barcode;

    public Product(int barcode, String productDescription, int price, int discountPercentage , int numberOfProduct) {
        this.productDescription = productDescription;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.numberOfProduct = numberOfProduct;
        this.barcode = barcode;

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
    public int getBarcode(){
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return barcode +")" + " " + productDescription +
                ", price = " + price +"₪" +
                ", Quantity in stock => " + numberOfProduct +
                "\n" + "\n";
    }


}
