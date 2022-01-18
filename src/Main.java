import java.util.Scanner;


public class Main {
    private static final int FIRST_MAIN_FIRST_OPTION = 1;
    private static final int FIRST_MAIN_SECOND_OPTION = 2;
    private static final int FIRST_MAIN_THIRD_OPTION = 3;
    private static final int FIRST_MAIN_NOT_IN_OPTION = 0;
    private static final int LIST_OF_CLIENT = 1 ;
    private static final int LIST_OF_CLIENT_VIP = 2 ;
    private static final int LIST_OF_CLIENT_WHO_BOUGHT_IN_THE_STORE = 3 ;
    private static final int CLIENT_WITH_BIGGER_BOUGHT = 4 ;
    private static final int ADD_PRODUCT = 5 ;
    private static final int PRODUCT_NOT_AVAILABLE = 6 ;
    private static final int EMPLOYEE_BUY = 7 ;
    private static final int END_PROGRAM = 8 ;

    public static void main(String[] args) {
        OnlineMarket onlineMarket = new OnlineMarket();
        Scanner scanner = new Scanner(System.in);
        int userSelection1;
        int userSelection2;
        do {
            do {
                System.out.println("""
                        Hello User, Please select one of the following options:
                        1 - Create an account
                        2 - Log in to an existing account
                        3 - Finish the program""");
                userSelection1 = scanner.nextInt();
            } while (userSelection1 > FIRST_MAIN_THIRD_OPTION || userSelection1 <= FIRST_MAIN_NOT_IN_OPTION);
            if (userSelection1 == FIRST_MAIN_FIRST_OPTION) {
                onlineMarket.createUser();
            }
            if (userSelection1 == FIRST_MAIN_SECOND_OPTION) {
                int logain = onlineMarket.userLogin();
                if (logain == FIRST_MAIN_NOT_IN_OPTION) {
                    System.out.println("User does not exist or one of the parameters is incorrect");
                } else {
                    if (logain == FIRST_MAIN_FIRST_OPTION) {
                        onlineMarket.clientBuy();
                    }
                    if (logain == FIRST_MAIN_SECOND_OPTION) {
                        userSelection2 = employeeMenu();
                        switch (userSelection2) {


                            case LIST_OF_CLIENT:
                                onlineMarket.listOfClient();
                                break;
                            case LIST_OF_CLIENT_VIP:
                                onlineMarket.listOfClientVip();
                                break;
                            case LIST_OF_CLIENT_WHO_BOUGHT_IN_THE_STORE:
                                onlineMarket.listOfClientWhoBoughtInTheStore();
                                break;
                            case CLIENT_WITH_BIGGER_BOUGHT:
                                onlineMarket.clientWithBiggerBought();
                                break;
                            case ADD_PRODUCT:
                                onlineMarket.addProduct();
                                break;
                            case PRODUCT_NOT_AVAILABLE:
                                onlineMarket.productNotAvailable();
                                break;
                            case EMPLOYEE_BUY:
                                onlineMarket.employeeBuy();
                                break;
                            case END_PROGRAM:
                                break;

                        }

                    }
                }
            }

        } while (userSelection1 != FIRST_MAIN_THIRD_OPTION);
    }

    public static int employeeMenu() {
        Scanner scanner = new Scanner(System.in);
        int userSelection;
        System.out.println("""
                1 - Print a list of all customers.
                2 - Print the list of customers who are members of the club only.
                3 - Print the list of customers who have made at least one purchase.
                4 - Print the customer whose purchase amount is the highest.
                5 - Adding a new product to the store.
                6 - Change inventory status for product.
                7 - Making a purchase.
                8 - Disconnect""");
        userSelection = scanner.nextInt();
        return userSelection;
    }
}
