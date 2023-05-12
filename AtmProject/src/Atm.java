import java.util.HashMap; // Import the HashMap class
import java.util.Scanner;  // Import the Scanner class

public class Atm{
    
    static double userBalance = 300.50;

    // Prints the available main menu options
    public static void atmMenu() {
        System.out.println("ATM Main menu\n1. check balance\n2. withdraw\n3. deposit\n4. change password\n5. quit");
    }

    // Check balance logic
    public static void checkBalance() {
        // Initializing while loop variable
        boolean isOpenMenu = true;

        // while loop responsible for the check balance sub-menu and to display user balance 
        while(isOpenMenu == true) {
            System.out.println("ATM check balance sub-menu");
            System.out.println("Your available balance is £" + userBalance + "\n");
            System.out.println("1. quit");
            System.out.print("Select menu option ");
            
            // loops till the user input is integer
            Scanner userMenuOption = new Scanner(System.in);
            while (!userMenuOption.hasNextInt()) {
                System.out.println("Input is not a number.");
                userMenuOption.nextLine();
            }
            
            int menuChoice = userMenuOption.nextInt();
            
            if (menuChoice == 1) {
               break;
            } else {
                // else if the user enters a number that's not available in the menu prints that the number selected is not an option
                // and continues the loop 
                System.out.println("Option " + menuChoice + " is not available.\nPlease check the menu bellow for available options.\n");
                continue;
            }
        }
    }

    // Withdraw balance logic
    public static void withdrawBalance() {
        // Initializing while loop variable
        boolean isOpenMenu = true;

        // while loop responsible for the withdraw balance sub-menu and to withdraw user balance 
        while(isOpenMenu == true) {
            System.out.println("ATM withdraw balance sub-menu");
            System.out.println("1. withdraw balance\n2. quit");
            System.out.print("Select menu option ");
            
            // loops till the user input is integer
            Scanner userMenuOption = new Scanner(System.in);
            while (!userMenuOption.hasNextInt()) {
                System.out.println("Input is not a number.");
                userMenuOption.nextLine();
            }
            
            int menuChoice = userMenuOption.nextInt();
            
            if (menuChoice == 1) {
                // ask's user the amount to withdraw
                boolean successfullWd = false;
                while (successfullWd == false) {
                    System.out.print("Enter amount to withdraw ");
                    
                    // loops till the user input is double data type
                    Scanner scanDouble = new Scanner(System.in);
                    while (!scanDouble.hasNextDouble()) {
                        System.out.println("Input is not a number.");
                        scanDouble.nextLine();
                    }
                    Double wd = scanDouble.nextDouble();
                    
                    // we make the user inpute absolute
                    wd = Math.abs(wd);

                    // we check if the amount request to withdraw is less or equal to the users available balance 
                    if(wd <= userBalance){
                        userBalance -= wd;
                        System.out.println("Successfully withdrawn £" + wd + " remaining balance £" + userBalance);
                        successfullWd = true;
                    } else {
                        // else we display that the withdraw request is greater than the available balance and we 
                        // continue the loop
                        System.out.println("Your withdraw amount is greater than the avalabile account balance.");
                        continue;
                    }
                }
            } else if (menuChoice == 2){
                break;
            } else {
                // else if the user enters a number that's not available in the menu prints that the number selected is not an option
                // and continues the loop 
                System.out.println("Option " + menuChoice + " is not available.\nPlease check the menu bellow for available options.\n");
                continue;
            } 
        }
    }

    public static void depositBalance() {
        // Initializing while loop variable
        boolean isOpenMenu = true;

        // while loop responsible for the deposit balance sub-menu and to deposit balance into user available balance
        while(isOpenMenu == true) {
            System.out.println("ATM deposit balance sub-menu");
            System.out.println("1. deposit balance\n2. quit");
            System.out.print("Select menu option ");
            
            // loops till the user input is integer
            Scanner userMenuOption = new Scanner(System.in);
            while (!userMenuOption.hasNextInt()) {
                System.out.println("Input is not a number.");
                userMenuOption.nextLine();
            }
            
            int menuChoice = userMenuOption.nextInt();
            
            if (menuChoice == 1) {
                // Initializing while loop variable
                boolean successfullDp = false;

                // while responsible for balance deposit into user available balance
                while (successfullDp == false) {
                    System.out.print("Enter amount to deposit: ");

                    // loops till the user input is double data type
                    Scanner scanDouble = new Scanner(System.in);
                    while (!scanDouble.hasNextDouble()) {
                        System.out.println("Input is not a number.");
                        scanDouble.nextLine();
                    }
                    Double deposit = scanDouble.nextDouble();

                    deposit = Math.abs(deposit);
            
                    // we make the user inpute absolute and we sum and store the input with the total user balance variable
                    userBalance += deposit;
                    System.out.println("Successfully deposited £" + deposit + " total new balance £" + userBalance);
                    successfullDp = true;
                }
            } else if (menuChoice == 2){
                break;
            } else {
                // else if the user enters a number that's not available in the menu prints that the number selected is not an option
                // and continues the loop 
                System.out.println("Option " + menuChoice + " is not available.\nPlease check the menu bellow for available options.\n");
                continue;
            } 
        }
    }
}
