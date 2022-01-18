import java.text.DateFormat;
import java.util.Date;

public class Client extends User {
    private static final int VIP_CLIENT = 1 ;
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
        if(typeClient == VIP_CLIENT){
            return super.toString() + "{ vip }\n" +  " Date of last purchase: " + getDate();
        } else {
            return super.toString();
        }
    }
}
