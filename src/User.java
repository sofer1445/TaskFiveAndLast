import java.sql.Date;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int numberOfPurchases;

    public User(String firstName, String lastName, String userName, String password, int numberOfPurchases) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.numberOfPurchases = numberOfPurchases;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(int numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    @Override
    public String toString() {
        return "Hello {" + firstName + " }"  + "{ " + lastName + "}" + "!";

    }
}
