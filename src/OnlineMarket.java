import java.util.*;


public class OnlineMarket {
    private static final int ARRAY_SIZE = 0;
    private static final int ARRAY_SIZE_PRODUCT = 5;
    private static final int CHOICE_RESULT = 2;
    private static final int LOCATION_ARRAY = 0;
    private static final int CLIENT = 1;
    private static final int EMPLOYEE = 2;
    private static final int LOCATION_ARRAY2 = 1;
    private static final int LAST_OPTION = 3;
    private static final int PASSWORD_LENGTH = 6;
    private static final int ITEMS = 0;
    private static final int BARCODE = 0;
    private static final int BARCODE1 = 1;
    private static final int BARCODE2 = 2;
    private static final int BARCODE3 = 3;
    private static final int BARCODE4 = 4;
    private static final int BARCODE5 = 5;
    private static final int PRICE_WHISKEY = 120;
    private static final int ARAK_PRICE = 65;
    private static final int VODKA_PRICE = 110;
    private static final int WINE_PRICE = 140;
    private static final int BEER_PRICE = 18;
    private static final int DISCOUNT_WISKEY_BEER = 10;
    private static final int DISCOUNT_ARAK_VODKA = 15;
    private static final int DISCOUNT_WINE = 20;
    private static final int AMOUNT_WHISKEY_VODKA_BEER = 10;
    private static final int AMOUNT_ARAK_WINE = 20;
    private static final int FINISH_SHOP = -1;
    private static final int START_TYPE_EMPLOYEE = 0;
    private static final int REGULAR_EMPLOYEE = 1;
    private static final int MANAGER_EMPLOYEE = 2;
    private static final int MEMBER_EMPLOYEE = 3;
    private static final double REGULAR_EMPLOYEE_DISCOUNT = 0.1;
    private static final double MANAGER_EMPLOYEE_DISCOUNT = 0.2;
    private static final double MEMBER_EMPLOYEE_DISCOUNT = 0.3;

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
        this.products = new Product[ARRAY_SIZE_PRODUCT];
        this.users = new User[ARRAY_SIZE];
        this.clients = new Client[ARRAY_SIZE];
        this.employees = new Employee[ARRAY_SIZE];


    }

    private int[] employeeOrCustomer() {
        Scanner scanner = new Scanner(System.in);
        int[] theChoiceResult = new int[CHOICE_RESULT];
        do {
            System.out.println("""
                    Please choose Are you an employee or a customer?
                    1 - Customer
                    2 - Employee""");
            theChoiceResult[LOCATION_ARRAY] = scanner.nextInt();
        } while (theChoiceResult[LOCATION_ARRAY] != CHOICE_RESULT && theChoiceResult[LOCATION_ARRAY] != LOCATION_ARRAY2); // אפס מיקום ראשון לעשות פיינל אחד מיקום שני לעשות גם פיינל
        if (theChoiceResult[LOCATION_ARRAY] == LOCATION_ARRAY2) {
            System.out.println("""
                    Are you a club member?
                    1 - Yes
                    2 - no""");
            theChoiceResult[LOCATION_ARRAY2] = scanner.nextInt();
        } else {
            do {
                System.out.println("""
                        Please select what type of employee you are:
                        1 - For a regular employee
                        2 - For a manager
                        3 - For a member of the management team""");
                theChoiceResult[LOCATION_ARRAY2] = scanner.nextInt();
            }
            while (theChoiceResult[LOCATION_ARRAY2] < LOCATION_ARRAY2 || theChoiceResult[LOCATION_ARRAY2] > LAST_OPTION);

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
        if (password.length() >= PASSWORD_LENGTH) {
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
        while (clientOrEmployee != CLIENT && clientOrEmployee != EMPLOYEE);
        System.out.println("Please enter a user name");
        String bug = scanner.nextLine();// אין לי מושג אבל זה פותר את התקלה
        String userName = scanner.nextLine();
        System.out.println("Type a password");
        String password = scanner.nextLine();
        if (clientOrEmployee == CLIENT) {
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
        int items = ITEMS;
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
        if (typeOfUser[ARRAY_SIZE] == CLIENT) {
            createEmployeeOrClient(user, typeOfUser);
        } else {
            createEmployeeOrClient(user, typeOfUser);
        }


    }

    public void createEmployeeOrClient(User user, int[] typeUser) {
        int typeOfUser;
        int numberOfPurchases = ITEMS;
        if (typeUser[LOCATION_ARRAY] == CLIENT) {
            typeOfUser = typeUser[LOCATION_ARRAY2];
            Client client = new Client(user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword(), numberOfPurchases, typeOfUser, user.getDate());
            addClientToArray(client);
        } else {
            typeOfUser = typeUser[LOCATION_ARRAY2];
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
        products[BARCODE] = new Product(BARCODE1, "Whiskey", PRICE_WHISKEY, DISCOUNT_WISKEY_BEER, AMOUNT_WHISKEY_VODKA_BEER);
        products[BARCODE1] = new Product(BARCODE2, "Arak", ARAK_PRICE, DISCOUNT_ARAK_VODKA, AMOUNT_ARAK_WINE);
        products[BARCODE2] = new Product(BARCODE3, "Vodka", VODKA_PRICE, DISCOUNT_ARAK_VODKA, AMOUNT_WHISKEY_VODKA_BEER);
        products[BARCODE3] = new Product(BARCODE4, "wine", WINE_PRICE, DISCOUNT_WINE, AMOUNT_ARAK_WINE);
        products[BARCODE4] = new Product(BARCODE5, "beer", BEER_PRICE, DISCOUNT_WISKEY_BEER, AMOUNT_WHISKEY_VODKA_BEER);
        inventory = new Inventory(products);


    }


    public void clientBuy() {
        int typeOfProduct = ITEMS;
        int items = ITEMS;
        shoppingCart = new ShoppingCart(inventory, products);
        Product[] customerCart = new Product[ARRAY_SIZE];
        Scanner scanner = new Scanner(System.in);
        listOfProducts();
        while (typeOfProduct != FINISH_SHOP) {
            inventory = new Inventory(products);
            System.out.print(inventory);
            System.out.println(" Which product would you like to buy? choose by barcode \n" +
                    "If you want to finish the purchase in the store, type -1 ");
            typeOfProduct = scanner.nextInt();
            while (items <= ITEMS && typeOfProduct != FINISH_SHOP) {
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
                    items = ITEMS;
                    System.out.println("Products in the current cart: \n" + customerCart[customerCart.length - 1].getProductDescription() + "--" + customerCart[customerCart.length - 1].getNumberOfProduct());
                    System.out.println("The current cart price is: " + resultOfTotalPrice(customerCart) + "₪");
                    if (products[i].getNumberOfProduct() < ITEMS) {
                        products[i].setNumberOfProduct(ITEMS);
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
            if (clients == null) {
                System.out.println("No customers exist");
                return;
            }
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
            if (clients[i].getNumberOfPurchases() >= CLIENT) {
                System.out.println("Customers who have made one or more purchases:\n" + clients[i]);
            }
        }

    }

    public void clientWithBiggerBought() {
        if (clients == null) {
            System.out.println("No customers exist");
            return;
        }
        Client preferredCustomer = clients[ARRAY_SIZE];
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
        int typeOfEmployee = START_TYPE_EMPLOYEE;
        System.out.println("Hello dear employee Welcome to the online store");
        clientBuy();
        Product[] shoppingCartForEmployee = shoppingCart.getAvailableProduct();
        priceForEmployee = resultOfTotalPrice(shoppingCartForEmployee);

        for (int i = 0; i < employees.length; ) {
            //  for (int j = 0; j < employees.length; j++) {
            //  if (this.employees[i].getDate().after(employees[j].getDate())) {
            typeOfEmployee = employees[i].getTypeOfEmployee();
            break;
        }


        switch (typeOfEmployee) {
            case REGULAR_EMPLOYEE -> {
                priceForEmployee = priceForEmployee - (priceForEmployee * REGULAR_EMPLOYEE_DISCOUNT); // לחפש משהו יותר יעיל לאחוזים
            }
            case MANAGER_EMPLOYEE -> {
                priceForEmployee = priceForEmployee - (priceForEmployee * MANAGER_EMPLOYEE_DISCOUNT);
            }
            case MEMBER_EMPLOYEE -> {
                priceForEmployee = priceForEmployee - (priceForEmployee * MEMBER_EMPLOYEE_DISCOUNT);
            }
        }
        System.out.println("Price after discount: " + priceForEmployee + "₪");


    }


}

