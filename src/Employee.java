public class Employee extends User{
    private int typeOfEmployee;


    public Employee(String firstName, String lastName, String userName, String password ,int numberOfPurchases, int typeOfEmployee) {
        super(firstName, lastName, userName, password, numberOfPurchases);
        this.typeOfEmployee = typeOfEmployee;
    }

    public int getTypeOfEmployee() {
        return typeOfEmployee;
    }

    public void setTypeOfEmployee(int typeOfEmployee) {
        this.typeOfEmployee = typeOfEmployee;
    }
    public String toString(){
       if(typeOfEmployee == 1){
           return super.toString() + " regular employee ";

       }
       if(typeOfEmployee == 2){
           return super.toString() + " manager ";
       }
       else {
           return super.toString() + " member of the management team ";
       }
    }
}
