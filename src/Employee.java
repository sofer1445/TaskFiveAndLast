public class Employee extends User{
    private int typeOfEmployee;

    public Employee(String firstName, String lastName, String userName, String password , int typeOfEmployee) {
        super(firstName, lastName, userName, password);
        this.typeOfEmployee = typeOfEmployee;
    }

    public int getTypeOfEmployee() {
        return typeOfEmployee;
    }

    public void setTypeOfEmployee(int typeOfEmployee) {
        this.typeOfEmployee = typeOfEmployee;
    }
}
