import java.text.DateFormat;
import java.util.Date;

public class Client extends User {
    private int typeClient;


    public Client(String firstName, String lastName, String userName, String password , int numberOfPurchases , int typeClient, Date date) {
        super(firstName, lastName, userName, password, numberOfPurchases, date);
        this.typeClient = typeClient;


    }

    public int getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(int typeClient) {
        this.typeClient = typeClient;
    }

    @Override
    public String toString() {
        if(typeClient == 1){
            return super.toString() + "{ vip }\n" +  " Date of last purchase: " + getDate();
        } else {
            return super.toString();
        }
    }
}
