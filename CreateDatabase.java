//Create DB in MySQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/";

    //User log in for DB
    static final String user = "root";
    static final String pass = "TheHub";


    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {

            //Sending connection request to the server
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to Database...");

            //logging in to the server
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "TheHub");
            System.out.println("Creating Database..");
            st = conn.createStatement();

            //creating the database
            String sql = "CREATE DATABASE IF NOT EXISTS thehub;";
            st.executeUpdate(sql);
            System.out.println("Database created successfully");

            //Accessing DB
            String sql2 = "USE thehub;";
            st.executeUpdate(sql2);


            //Creating profiles table
            String sql3 = "CREATE TABLE profiles " +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, " +
                    " firstname VARCHAR(255), " +
                    " lastname VARCHAR(255), " +
                    " username VARCHAR(255), " +
                    " password VARCHAR(255), " +
                    " gender VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " bio VARCHAR(255), " +
                    " location VARCHAR(255), " +
                    " phone_number VARCHAR(50)) ;";
            st.executeUpdate(sql3);
            System.out.println("Table created successfully...");


            //Creating events table
            String sql4 = "CREATE TABLE IF NOT EXISTS events " +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, " +
                    " date INT(255), " +
                    " host VARCHAR(255), " +
                    " event_name VARCHAR(255), " +
                    " event_type VARCHAR(255), " +
                    " description VARCHAR(255), " +
                    " all_ages VARCHAR(255), " +
                    " entry_fee INT(255));";
            st.executeUpdate(sql4);
            System.out.println("Table created successfully...");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if ( st!= null)
                    st.close();
            } catch (SQLException e1) {

            } try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        };
        System.out.println("Goodbye..");
    }


}