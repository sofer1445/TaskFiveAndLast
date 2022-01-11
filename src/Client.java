public class Client extends User {
    private int typeClient;

    public Client(String firstName, String lastName, String userName, String password , int typeClient) {
        super(firstName, lastName, userName, password);
        this.typeClient = typeClient;

    }

    public int getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(int typeClient) {
        this.typeClient = typeClient;
    }
}
