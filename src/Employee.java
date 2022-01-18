import java.text.DateFormat;
import java.util.Date;


public class Employee extends User{
    private int typeOfEmployee;
    private static final int REGULAR_EMPLOYEE = 1 ;
    private static final int MANAGER_EMPLOYEE = 2 ;

    public Employee(String firstName, String lastName, String userName, String password , int numberOfPurchases, int typeOfEmployee , Date date) {
        super(firstName, lastName, userName, password, numberOfPurchases, date);
        this.typeOfEmployee = typeOfEmployee;
    }

    public int getTypeOfEmployee() {
        return typeOfEmployee;
    }

    public void setTypeOfEmployee(int typeOfEmployee) {
        this.typeOfEmployee = typeOfEmployee;
    }
    public String toString(){
        if(typeOfEmployee == REGULAR_EMPLOYEE){
            return super.toString() + " regular employee ";

        }
        if(typeOfEmployee == MANAGER_EMPLOYEE){
            return super.toString() + " manager ";
        }
        else {
            return super.toString() + " member of the management team ";
        }
    }
}
