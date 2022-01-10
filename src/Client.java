public class Client extends User {
    private boolean typeClient;

    public Client(String firstName, String lastName, String userName, String password , boolean typeClient) {
        super(firstName, lastName, userName, password);
        this.typeClient = typeClient;

    }
}
