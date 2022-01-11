import java.util.Scanner;

public class Main {
    private static Client[] clients;

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
                User logain = onlineMarket.userLogin();
                if (logain == null) {
                    System.out.println("User does not exist or one of the parameters is incorrect");
                } else {
                    do {
                        userSelection2 = internalMenu();
                        switch (userSelection2){
                            case 1 :
                                break;
                            case 2 :
                                break;
                            case 3 :
                                break;
                            case 4 :
                                break;
                            case 5 :
                                break;
                            case 6 :
                                break;
                            case 7 :
                                break;
                            case 8 :
                                break;

                        }
                    } while (userSelection2 != 8);
                }
            }


        } while (userSelection1 != 3);
    }

    public static int internalMenu (){
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
