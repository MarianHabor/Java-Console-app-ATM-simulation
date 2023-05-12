import java.util.HashMap; // Import the HashMap class
import java.util.Scanner; // Import the Scanner class

public class User {

    static Boolean isPwChanged = false;
    static String pw = "";

    // Prints the username of current users
    public void currentUsers() {

        String[] userAccounts = {"username : password", "Jhon : London1", "Emily : London2", "Michael : London3", "Alison : London4"};

        for (int i = 0; i < userAccounts.length; i++) {
            System.out.println(userAccounts[i]);
        }
    }

    // Users accounts and their password
    public static String storedUsers(String username) {
        HashMap<String, String> userAccount = new HashMap<String, String>();

        userAccount.put("Jhon", "London1");
        userAccount.put("Emily", "London2");
        userAccount.put("Michael", "London3");
        userAccount.put("Alison", "London4");


        // returns password
        return userAccount.get(username);
    }

    // Hashmap of the user's account type with access key their name
    public static String accountType(String username) {
        HashMap<String, String> userAccount = new HashMap<String, String>();

        // Users accounts and their account type
        userAccount.put("Jhon", "saving");
        userAccount.put("Emily", "current");
        userAccount.put("Michael", "saving");
        userAccount.put("Alison", "business");

        return userAccount.get(username);        
    }

    // User login logic
    public String UserLoggin() {
        System.out.println("Please enter the user you want to login as.");

        // Stores the username of the logged user
        String usernameReturn = null;

        // Initializing while loop variable
        boolean userExist = false;

        // while loop responsible for to check that the username inputted by the user exists 
        while (userExist == false) {
            Scanner userObj = new Scanner(System.in);
            System.out.print("Enter username: ");
    
            String username = userObj.nextLine();

            // if username exists promps the user for the account password
            if(storedUsers(username) != null){
                System.out.print("Please enter your password: ");

                // Initializing while loop variable
                Boolean isCorrectPin = false;

                // while loop responsible for to check that the password inputted by the user is correct 
                while (isCorrectPin == false) {
                    String pin = userObj.nextLine();

                    if(pin.equals(storedUsers(username))){
                        // prints the account type the user has and logs the user
                        String accType = accountType(username);
                        System.out.println("Hi " + username + " you have a " + accType + " account.");
                        isCorrectPin = true;
                        userExist = true;

                        // we store the username in usernameReturn varible as we can not
                        // return from a while loop
                        usernameReturn = username;
                    } else {
                        System.out.println("Wrong password\nPlease try again.");
                    }
                }
            } else {
                System.out.println("Username dosen't exist.");
            }
        }
        return usernameReturn;
    }

    // Change password logic
    public static void changePassword(String username) {
        // Initializing while loop variable
        Boolean isOpenMenu = true;

        // while loop responsible for the change password sub-menu and to change the user password 
        while(isOpenMenu == true){
            System.out.println("ATM change password sub-menu");
            System.out.println("1. change password\n2. view current password\n3. quit");
            System.out.print("Select menu option ");

            // loops till the user input is integer
            Scanner option = new Scanner(System.in);
            while (!option.hasNextInt()) {
                System.out.println("Input is not a number.");
                option.nextLine();
            }
            
            int choice = option.nextInt();

            if (choice == 1) {
                // handles the password change
                Scanner userPwObj = new Scanner(System.in);
                System.out.print("Enter your new password: ");

                String password = userPwObj.nextLine();

                // every time the user change the password we store it
                // in pw varible
                pw = password;
                isPwChanged = true;
                System.out.println("Password changed successfuly.");

            } else if (choice == 2) {
                // sub-menu choice 2 prints the current password
                // if the password has been changed by the user we print from the pw varible
                // else we call the method storedUsers(username) with parameter the username of the logged user
                if (isPwChanged == true) {
                    System.out.println("Your password is " + pw);
                } else {
                    System.out.println("Your password is " + storedUsers(username));
                }

            } else if (choice == 3) {
                // exits sub-menu and return back to main menu
                break;
            } else {
                // else if the user enters a number that's not available in the menu prints that the number selected is not an option
                // and continues the loop 
                System.out.println("Option " + choice + " is not available.\nPlease check the menu bellow for available options.\n");
                continue;
            }
        }
    }
}
