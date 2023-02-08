import java.util.HashMap;
import java.util.Scanner;

public class UserLogin {

    // Store all registered users and their passwords in a HashMap
    static HashMap<String, String> dummyUsers = new HashMap<>();


    //this needs to be converted into an input system for users when they register
    static {
        dummyUsers.put("user1", "pass1");
        dummyUsers.put("user2", "pass2");
        dummyUsers.put("user3", "pass3");
    }

    // A class to store user information
    static class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.print("Password: ");
        String password = input.nextLine();

        if (dummyUsers.containsKey(username) && dummyUsers.get(username).equals(password)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed!");
        }
    }
}