import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class UserLogin {

    Connection conn = null;

    static final String URL = "jdbc:mysql://192.168.72.21:3306/";

    //User log in for DB
    static final String USER = "TheHub";
    static final String PASS = "$TheHub2023$";

    public void login() throws RuntimeException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        try {

            DBConnect.getInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Query the database for the user's credentials
            String query = "SELECT username, password FROM profiles WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            // Check if the user's credentials match the data from the database
            if (rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            //check if username or password is empty
            if (username.isEmpty() || password.isEmpty()) {
                //if either is empty, print message
                System.out.println("Username and password cannot be empty");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No input found, please try again.");
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}