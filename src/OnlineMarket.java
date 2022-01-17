import java.sql.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class OnlineMarket {
    private Product[] products;
    private ShoppingCart shoppingCart;
    private Client[] clients;
    private Inventory inventory;
    private Employee[] employees;
    private User[] users; //

    public OnlineMarket(Inventory inventory, ShoppingCart shoppingCart) {
        this.inventory = inventory;
        this.shoppingCart = shoppingCart;

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
        int items = 0;
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
        Date date = new Date();
        User user = new User(firstName, lastName, userName, password, items, date);
        addUserToArray(user);
        if (typeOfUser[0] == 1) {
            createEmployeeOrClient(user, typeOfUser);
        } else {
            createEmployeeOrClient(user, typeOfUser);
        }


    }

    public void createEmployeeOrClient(User user, int[] typeUser) {
        int typeOfUser;
        int numberOfPurchases = 0;
        if (typeUser[0] == 1) {
            typeOfUser = typeUser[1];
            Client client = new Client(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), numberOfPurchases, typeOfUser, user.getDate());
            addClientToArray(client);
        } else {
            typeOfUser = typeUser[1];
            Employee employee = new Employee(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), numberOfPurchases, typeOfUser, user.getDate());
            addEmployeeArray(employee);
        }

    }

    private void addEmployeeArray(Employee employee) {
        Employee[] newArrayOfEmployee = new Employee[this.employees.length + 1];
        for (int i = 0; i < this.employees.length; i++) {
            newArrayOfEmployee[i] = this.employees[i];
        }
        Employee userToAddClient = new Employee(employee.getFirstName(), employee.getLastName(), employee.getUserName(), employee.getPassword(), employee.getNumberOfPurchases(), employee.getTypeOfEmployee(), employee.getDate());
        newArrayOfEmployee[this.employees.length] = userToAddClient;
        this.employees = newArrayOfEmployee;
    }

    private void addClientToArray(Client client) {
        Client[] newArrayOfClient = new Client[this.clients.length + 1];
        for (int i = 0; i < this.clients.length; i++) {
            newArrayOfClient[i] = this.clients[i];
        }
        Client userToAddClient = new Client(client.getFirstName(), client.getLastName(), client.getUserName(), client.getPassword(), client.getNumberOfPurchases(), client.getTypeClient(), client.getDate());
        newArrayOfClient[this.clients.length] = userToAddClient;
        this.clients = newArrayOfClient;

    }

    private Product[] addProductToArray(Product product, Product[] cart) {
        Product[] newArrayOfProduct = new Product[cart.length + 1];
        for (int i = 0; i < cart.length; i++) {
            newArrayOfProduct[i] = cart[i];
        }
        Product userToAddProduct = new Product(product.getBarcode(), product.getProductDescription(), product.getPrice(), product.getDiscountPercentage(), product.getNumberOfProduct());
        newArrayOfProduct[cart.length] = userToAddProduct;
        cart = newArrayOfProduct;
        return cart;
    }

    private void addUserToArray(User user) {
        User[] newArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newArray[i] = this.users[i];
        }
        User userToAdd = new User(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), user.getNumberOfPurchases(), user.getDate());
        newArray[this.users.length] = userToAdd;
        this.users = newArray;

    }

    public void listOfProducts() {
        if (inventory != null) {
            return;
        }
        products[0] = new Product(1, "Whiskey", 120, 10, 5);
        products[1] = new Product(2, "Arak", 65, 15, 20);
        products[2] = new Product(3, "Vodka", 110, 5, 8);
        products[3] = new Product(4, "wine", 140, 20, 20);
        products[4] = new Product(5, "beer", 18, 10, 60);
        inventory = new Inventory(products);


    }

    public void clientBuy() {
        int typeOfProduct = 0;
        int items = 0;
        shoppingCart = new ShoppingCart(inventory, products);
        Product[] customerCart = new Product[0];
        Scanner scanner = new Scanner(System.in);
        listOfProducts();
        while (typeOfProduct != -1) {
            inventory = new Inventory(products);
            System.out.print(inventory);
            System.out.println(" Which product would you like to buy? choose by barcode \n" +
                    "If you want to finish the purchase in the store, type -1 ");
            typeOfProduct = scanner.nextInt();
            while (items <= 0 && typeOfProduct != -1) {
                System.out.println("Quantity of items requested?");
                items = scanner.nextInt();
            }
            for (int i = 0; i < products.length; i++) {
                if (products[i].getBarcode() == typeOfProduct) {
                    products[i].setNumberOfProduct(products[i].getNumberOfProduct() - items);
                    inventory.setProducts(products);
                    shoppingCart.setAvailableInventory(inventory);
                    customerCart = addProductToArray(products[i], customerCart);
                    customerCart[customerCart.length - 1].setNumberOfProduct(items);
                    items = 0;
                    System.out.println("Products in the current cart: \n" + customerCart[customerCart.length - 1].getProductDescription() + "--" + customerCart[customerCart.length - 1].getNumberOfProduct());
                    System.out.println("The current cart price is: " + resultOfTotalPrice(customerCart) + "₪");
                    if (products[i].getNumberOfProduct() < 0) {
                        products[i].setNumberOfProduct(0);
                        System.out.println("Unfortunately the product is out of stock");
                        break;
                    }
                }
            }

        }
        int totalPrice = resultOfTotalPrice(customerCart);
        shoppingCart.setAvailableProduct(customerCart);
        for (int i = 0; i < customerCart.length; i++) {
            System.out.println(customerCart[i].getProductDescription() + "--" + customerCart[i].getNumberOfProduct());

        }
        System.out.println("price:" + totalPrice + "₪");
        users[users.length - 1].setNumberOfPurchases(users[users.length - 1].getNumberOfPurchases() + 1);
    }

    public void listOfClient() {
        if (clients == null) {
            System.out.println("No customers exist");
            return;
        }
        System.out.println("List of all customers in the store");
        for (int i = 0; i < clients.length; i++) {
            System.out.println(clients[i]);

        }
    }

    public void listOfClientVip() {
        if (clients == null) {
            System.out.println("No customers exist");
            return;
        }
        System.out.println("List of all vip client in the store");
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getTypeClient() == 1) {
                System.out.println(clients[i]);

            }

        }
        if (clients.length == 0) {
            System.out.println("There are no VIP customers in the system");
        }
    }

    public void listOfClientWhoBoughtInTheStore() {
        if (clients == null) {
            System.out.println("No customers exist");
            return;
        }
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].getNumberOfPurchases() >= 1) {
                System.out.println("Customers who have made one or more purchases:\n" + clients[i]);
            }
        }

    }

    public void clientWithBiggerBought() {
        if (clients == null) {
            System.out.println("No customers exist");
            return;
        }
        Client preferredCustomer = clients[0];
        for (int i = 0; i < clients.length; i++) {
            if (preferredCustomer.getNumberOfPurchases() < clients[i].getNumberOfPurchases()) {
                preferredCustomer = clients[i];
            }
        }
        System.out.println("The customer with the highest number of purchases is: " + preferredCustomer);
    } // נבדק רק פעמיים לנסות למצוא באגים...

    public int resultOfTotalPrice(Product[] products) {
        int totalPrice = 0;
        for (int i = 0; i < products.length; i++) {
            totalPrice = ((products[i].getPrice() * products[i].getNumberOfProduct()) + totalPrice);
        }
        return totalPrice;
    }

    public void addProduct() {
        listOfProducts();
        int barcode = products[products.length - 1].getBarcode();
        barcode++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a product name:");
        String nameOfProduct = scanner.nextLine();
        System.out.println("Enter product price:");
        int price = scanner.nextInt();
        System.out.println("Percentage discount for club member:");
        int discountForClub = scanner.nextInt();
        System.out.println("Units in Stock:");
        int unitesInStock = scanner.nextInt();
        Product productNew = new Product(barcode, nameOfProduct, price, discountForClub, unitesInStock);
        products = addProductToArray(productNew, products);
        inventory = new Inventory(products);

    }

    public void productNotAvailable() {
        listOfProducts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a product that you would like to remove from stock or put in stock");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);

        }
        int numberProduct = scanner.nextInt();
        products[numberProduct - 1] = null;
        inventory = new Inventory(products);
        System.out.println(products[numberProduct].getProductDescription() + ": This product is out of stock ");

    }

    public void employeeBuy() {
        double priceForEmployee = 0;
        double discountPercentage;
        int typeOfEmployee = 0;
        System.out.println("Hello dear employee Welcome to the online store");
        clientBuy();
        Product[] shoppingCartForEmployee = shoppingCart.getAvailableProduct();
        priceForEmployee = resultOfTotalPrice(shoppingCartForEmployee);

        for (int i = 0; i < employees.length ; i++) {
            for (int j = 0; j < employees.length; j++) {
                if (this.employees[i].getDate().after(employees[j].getDate())) {
                    typeOfEmployee = employees[i].getTypeOfEmployee();
                    break;
                }

            }
        }
        switch (typeOfEmployee) {
            case 1 -> {
                discountPercentage = 10;
                priceForEmployee = priceForEmployee - (priceForEmployee * (discountPercentage / 100)); // לחפש משהו יותר יעיל לאחוזים
            }
            case 2 -> {
                discountPercentage = 20;
                priceForEmployee = priceForEmployee - (priceForEmployee * (discountPercentage / 100));
            }
            case 3 -> {
                discountPercentage = 30;
                priceForEmployee = priceForEmployee - (priceForEmployee * (discountPercentage / 100));
            }
        }
        System.out.println("Price after discount: " + priceForEmployee + "₪");


    }

}

