import java.util.Scanner;


public class Main {
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
            } while (userSelection1 > 3 || userSelection1 <= 0);
            if (userSelection1 == 1) {
                 onlineMarket.createUser();
            }
            if (userSelection1 == 2) {
                int logain = onlineMarket.userLogin();
                if (logain == 0) {
                    System.out.println("User does not exist or one of the parameters is incorrect");
                } else {
                        if(logain == 1){
                            onlineMarket.clientBuy();
                        }
                        if(logain == 2) {
                            userSelection2 = employeeMenu();

                            switch (userSelection2) {
                                case 1:
                                    onlineMarket.listOfClient();
                                case 2:
                                    onlineMarket.listOfClientVip();
                                case 3:
                                    onlineMarket.listOfClientWhoBoughtInTheStore();
                                case 4:
                                    onlineMarket.clientWithBiggerBought();
                                case 5:
                                    onlineMarket.addProduct();
                                case 6:
                                    onlineMarket.productNotAvailable();
                                case 7:
                                    onlineMarket.employeeBuy();
                                case 8:
                                    break;

                            }
                        }
                }

            }


        } while (userSelection1 != 3);
    }

    public static int employeeMenu (){
        Scanner scanner = new Scanner(System.in);
        int userSelection ;
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
