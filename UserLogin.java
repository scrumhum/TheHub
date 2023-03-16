import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;


public class UserLogin {


    // A class to store user information
    public static void login() throws RuntimeException {
        /*
        //Scanner initialized
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = sc.nextLine(); //saves what's entered to username String variable
        System.out.print("Enter your password: ");
        String password = sc.nextLine(); //saves what's entered to String password variable
        try {
            Map<String,UserData> uMap = Registry.getUserMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            //check if username or password is empty
            if (username.isEmpty() || password.isEmpty()) {
                //if either is empty, print message
                System.out.println("Username and password cannot be empty");
                return;
            }
            //try to authenticate the user with the given username and password
            UserData userData = (UserData) umap.get(username);
            DummyUser user = testAuthenticate(userData, password);
            //check if authentication was successful
            if (user != null) {
                //if it was successful, call the method to print the user's role
                printUserRole(user);
                try {
                    user.loggedIn();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                //if authentication failed, print error messages
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No input found, please try again.");
        }
    }
    //Added test auth method, the other one should work now as well, but leaving this one in place. These shouldn't need
    //to change much.
    private static DummyUser testAuthenticate(UserData user, String passwordInput) {
        //this validates the password based on userdata objects stored and calls the userfactory to
        if (Objects.equals(user.password, passwordInput)) {
            DummyUser validatedUser = UserFactory.buildUser(user);
            return validatedUser;
        } else {
            System.out.println("Username or password is incorrect");
            return null;
        }*/
    }
}