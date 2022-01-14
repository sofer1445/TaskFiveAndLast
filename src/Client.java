public class Client extends User {
    private int typeClient;
    private int numberOfPurchases;

    public Client(String firstName, String lastName, String userName, String password , int typeClient , int numberOfPurchases) {
        super(firstName, lastName, userName, password);
        this.typeClient = typeClient;
        this.numberOfPurchases = numberOfPurchases;

    }

    public int getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(int typeClient) {
        this.typeClient = typeClient;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(int numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    @Override
    public String toString() {
        if(typeClient == 1){
            return super.toString() + "{ vip }";
        } else {
            return super.toString();
        }
    }
}
