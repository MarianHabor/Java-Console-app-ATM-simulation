import java.util.Scanner;  // Import the Scanner class

public class Main{
    public static void main(String[] args) {
        try {
            // Instance of User and Atm class
            User userAccount = new User();
            Atm userAtm = new Atm();
            
            // Calling currentUsers method from User class
            // this method prints the available users
            userAccount.currentUsers();

            // Calling UserLoggin method from User class
            // this method handles user login
            // and storing the return to a variable name username
            String username = userAccount.UserLoggin();

            // Initializing while loop variable
            boolean isOpenMenu = true;

            // Main while loop responsible for the ATM main menu
            while(isOpenMenu == true){
                // Calling atmMenu method from Atm class
                // this method prints the main menu
                userAtm.atmMenu();
                System.out.print("Select menu option: ");

                // Scanner that looks for user input
                // and loops around if the input is not integer
                Scanner userMenuOption = new Scanner(System.in);
                while (!userMenuOption.hasNextInt()) {
                    System.out.println("Input is not a number.");
                    userMenuOption.nextLine();
                }
                
                // User integer input stored to variable menuChoice
                int menuChoice = userMenuOption.nextInt();

                // if else if statment to control the users menu choice 
                if (menuChoice == 1) {
                    // check balance method from Atm class
                    userAtm.checkBalance();

                } else if (menuChoice == 2) {
                    // withdraw balance method from Atm class
                    userAtm.withdrawBalance();

                } else if (menuChoice == 3) {
                    // deposit balance method from Atm class
                    userAtm.depositBalance();

                } else if (menuChoice == 4){
                    // change user password method from User class
                    userAccount.changePassword(username);

                } else if (menuChoice == 5){
                    // set's the isOpenMenu variable to false and exits the program
                    System.out.println("Goodbye see you again soon.");
                    isOpenMenu = false;
                    
                } else {
                    // else if the user enters a number that's not available in the menu prints that the number selected is not an option
                    // and continues the loop 
                    System.out.println("Option " + menuChoice + " is not available.\nPlease check the menu bellow for available options.");
                    continue;
                }
            }
        } catch (Exception e) {
            // this catch will ensure if anything in the program goes wrong it will
            // catch the error and will exit with the bellow message
            System.out.println("Something went wrong please try again.");
        }
    }
}
