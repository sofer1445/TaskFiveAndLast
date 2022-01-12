import java.sql.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class OnlineMarket {
    private Product[] products;
    private ShoppingCart shoppingCart;
    private Client[] clients;
    private Inventory inventory;
    private Employee[] employees;
    private User[] users; // לא בטוח שצריך צריכה הסבר

    public OnlineMarket(Inventory inventory) {
        this.inventory = inventory;
    }

    public OnlineMarket() {
        this.products = new Product[5];
        this.users = new User[0];
        this.clients = new Client[0];
        this.employees = new Employee[0];

    }


    public int[] employeeOrCustomer() {
        Scanner scanner = new Scanner(System.in);
        int[] theChoiceResult = new int[2];
        do {
            System.out.println("""
                    Please choose Are you an employee or a customer?
                    1 - Customer
                    2 - Employee""");
            theChoiceResult[0] = scanner.nextInt();
        } while (theChoiceResult[0] != 2 && theChoiceResult[0] != 1); // אפס מיקום ראשון לעשות פיינל אחד מיקום שני לעשות גם פיינל
        if (theChoiceResult[0] == 1) {
            System.out.println("""
                    Are you a club member?
                    1 - Yes
                    2 - no""");
            theChoiceResult[1] = scanner.nextInt();
        } else {
            do {
                System.out.println("""
                        Please select what type of employee you are:
                        1 - For a regular employee
                        2 - For a manager
                        3 - For a member of the management team""");
                theChoiceResult[1] = scanner.nextInt();
            }
            while (theChoiceResult[1] < 1 || theChoiceResult[1] > 3);

        }
        return theChoiceResult;
    }

    public boolean checkRightName(String name) {
        name = name.toLowerCase(Locale.ROOT);
        for (int i = 0; i < name.length(); i++) {
            if (!(name.charAt(i) >= 'a' && name.charAt(i) <= 'z')) {
                return false;
            }
        }
        return true;
    }

    private boolean userAvailability(String user) {
        boolean checkAvailability = true;
        for (int i = 0; i < users.length; i++) {
            User currentUser = this.users[i];
            if (currentUser.getUserName().equals(user)) {
                checkAvailability = false;
                break;
            }

        }
        return checkAvailability;
    }

    private boolean passwordCheck(String password) {
        if (password.length() >= 6) {
            return true;
        }
        return false;
    }


    public int userLogin() {
        Scanner scanner = new Scanner(System.in);
        int clientOrEmployee;
        do {
            System.out.println("""
                    Press 1 or 2
                    1 - Client account
                    2 - Employee account""");
            clientOrEmployee = scanner.nextInt();
        }
        while (clientOrEmployee != 1 && clientOrEmployee != 2);
        System.out.println("Please enter a user name");
        String bug = scanner.nextLine();// אין לי מושג אבל זה פותר את התקלה
        String userName = scanner.nextLine();
        System.out.println("Type a password");
        String password = scanner.nextLine();
        if (clientOrEmployee == 1) {
            for (int i = 0; i < clients.length; i++) {
                if (Objects.equals(clients[i].getUserName(), userName) && Objects.equals(clients[i].getPassword(), password)) {
                    System.out.println(clients[i]);
                    return clientOrEmployee;
                }

            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (Objects.equals(employees[i].getUserName(), userName) && Objects.equals(employees[i].getPassword(), password)) {
                System.out.println(employees[i]);
                return clientOrEmployee;
            }

        }
        return 0;

    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        int[] typeOfUser = employeeOrCustomer();
        System.out.println("Please enter your first name:");
        String firstName = scanner.nextLine();
        boolean withoutNumber = checkRightName(firstName);
        while (!withoutNumber) {
            System.out.println("Please enter your name without number's");
            firstName = scanner.nextLine();
            withoutNumber = checkRightName(firstName);
        }
        System.out.println("Please enter your last name:");
        String lastName = scanner.nextLine();
        boolean withoutNumber1 = checkRightName(lastName);
        while (!withoutNumber1) {
            System.out.println("Please enter your name without number's");
            firstName = scanner.nextLine();
            withoutNumber1 = checkRightName(firstName);
        }
        System.out.println("Please choose a user name");
        String userName = scanner.nextLine();
        boolean checkAvailability = userAvailability(userName);
        while (!checkAvailability) {
            System.out.println("Existing system user, Try again.");
            userName = scanner.nextLine();
            checkAvailability = userAvailability(userName);
        }
        System.out.println("Please choose a password, With at least 6 characters: ");
        String password = scanner.nextLine();
        boolean goodPassword = passwordCheck(password);
        while (!goodPassword) {
            System.out.println("please try again");
            password = scanner.nextLine();
            goodPassword = passwordCheck(password);
        }
        User user = new User(firstName, lastName, userName, password);
        addUserToArray(user);
        if (typeOfUser[0] == 1) {
            createEmployeeOrClient(user, typeOfUser);
        } else {
            createEmployeeOrClient(user, typeOfUser);
        }


    }

    public void createEmployeeOrClient(User user, int[] typeUser) {
        int typeOfUser;
        if (typeUser[0] == 1) {
            typeOfUser = typeUser[1];// מה הסוג שלו( VIP או רגיל)
            Client client = new Client(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), typeOfUser);
            addClientToArray(client);
        } else {
            typeOfUser = typeUser[1];
            Employee employee = new Employee(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), typeOfUser);
            addEmployeeArray(employee);
        }

    }
    private void addEmployeeArray(Employee employee) {
        Employee[] newArrayOfEmployee = new Employee[this.employees.length + 1];
        for (int i = 0; i < this.employees.length; i++) {
            newArrayOfEmployee[i] = this.employees[i];
        }
        Employee userToAddClient = new Employee(employee.getFirstName(), employee.getLastName(), employee.getUserName(), employee.getPassword(), employee.getTypeOfEmployee());
        newArrayOfEmployee[this.employees.length] = userToAddClient;
        this.employees = newArrayOfEmployee;
    }

    private void addClientToArray(Client client) {
        Client[] newArrayOfClient = new Client[this.clients.length + 1];
        for (int i = 0; i < this.clients.length; i++) {
            newArrayOfClient[i] = this.clients[i];
        }
        Client userToAddClient = new Client(client.getFirstName(), client.getLastName(), client.getUserName(), client.getPassword(), client.getTypeClient());
        newArrayOfClient[this.clients.length] = userToAddClient;
        this.clients = newArrayOfClient;

    }

    private void addUserToArray(User user) {
        User[] newArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newArray[i] = this.users[i];
        }
        User userToAdd = new User(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword());
        newArray[this.users.length] = userToAdd;
        this.users = newArray;

    }

    public void listOfProducts(){

        products[0] = new Product("Whiskey" , 120 , 10 , 5);
        products[1] = new Product("Arak" , 65 , 15 , 20);
        products[2] = new Product("Vodka" , 110 , 5 , 8);
        products[3] = new Product("wine" , 140 , 20 , 20);
        products[4] = new Product("beer" , 18 , 10 , 60);


    }
    public void clientBuy() {
        Scanner scanner = new Scanner(System.in);
//        listOfProducts();
//        Inventory inventory =new Inventory(products);
//        System.out.println(inventory);
        for (int i = 0; i < products.length; i++) {
            System.out.print(i+1 + " ,");
            System.out.println(products[i]);

        }
        System.out.println("Which product would you like to buy?");
        int typeOfProduct = scanner.nextInt();// להוסיף מקט למוצר


    }

}

