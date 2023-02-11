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
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to Database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "TheHub");

            System.out.println("Creating Database..");
            st = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS users";
            st.executeUpdate(sql);
            System.out.println("Database created successfully");
            String sql2 = "CREATE DATABASE IF NOT EXISTS events";
            st.executeUpdate(sql2);
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
        }
        System.out.println("Goodbye..");
    }

}
